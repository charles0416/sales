package com.eeee.sh2.sales.controllers;

import com.eeee.sh2.sales.exceptions.RecordNotFoundException;
import com.eeee.sh2.sales.model.PersistentObject;
import com.eeee.sh2.sales.services.BaseDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Charles on 8/18/2017.
 */
public abstract class AbstractDataRestController<SERV extends BaseDataService, DO extends PersistentObject> {

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<DO> add(@RequestBody DO dataObject) {
        DO obj = (DO) this.getService().add(dataObject);
        return new ResponseEntity<DO>(obj, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DO> retrive(@PathVariable Long id) {
        Optional<DO> c = getService().find(id);
        if (c.isPresent()) {
            return new ResponseEntity<DO>(c.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DO> retriveAll() {
        return getService().listAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<DO> update(@PathVariable Long id, @RequestBody DO dataObject) {
        DO updatedRecord = null;
        if (id != dataObject.getId()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            updatedRecord = (DO) getService().update(dataObject);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DO>(updatedRecord, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public int saveAll(@RequestBody List<DO> recordList) {
        return getService().saveAll(recordList).size();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delete(@PathVariable Long id) {
        return getService().delete(id);
    }

    protected abstract SERV getService();
}
