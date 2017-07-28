package com.eeee.sh2.sales.controllers;

import com.eeee.sh2.sales.exceptions.BadRequestException;
import com.eeee.sh2.sales.model.Account;
import com.eeee.sh2.sales.model.Customer;
import com.eeee.sh2.sales.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Arrays;
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
    public int saveOrUpdate(@RequestBody List<Customer> customerList) {
        return customerService.saveAll(customerList).size();
    }

    private class CustomerList extends ArrayList<Customer> {
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer findById(@PathVariable Long id) {
        Optional<Customer> c = customerService.find(id);
        return c.orElse(null);
    }
}
