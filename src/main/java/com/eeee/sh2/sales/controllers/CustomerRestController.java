package com.eeee.sh2.sales.controllers;

import com.eeee.sh2.sales.exceptions.RecordNotFoundException;
import com.eeee.sh2.sales.model.Customer;
import com.eeee.sh2.sales.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Charles on 28/07/2017.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Customer> add(@RequestBody Customer customer) {
        Customer c = customerService.save(customer);
        return new ResponseEntity<Customer>(c, HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> retrive(@PathVariable Long id) {
        Optional<Customer> c = customerService.find(id);
        if (c.isPresent()) {
            return new ResponseEntity<Customer>(c.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> retriveAll() {
        return customerService.listAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = null;
        if (id != customer.getId()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            updatedCustomer = customerService.update(customer);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public int saveAll(@RequestBody List<Customer> customerList) {
        return customerService.saveAll(customerList).size();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delete(@PathVariable Long id) {
        return customerService.delete(id);
    }
}
