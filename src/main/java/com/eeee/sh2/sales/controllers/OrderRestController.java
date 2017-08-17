package com.eeee.sh2.sales.controllers;

import com.eeee.sh2.sales.model.Customer;
import com.eeee.sh2.sales.model.Order;
import com.eeee.sh2.sales.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Charles on 28/07/2017.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public int saveOrUpdate(@RequestBody List<Order> orderList) {
        return orderService.saveAll(orderList).size();
    }

    private class CustomerList extends ArrayList<Customer> {
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Optional<Order> order = orderService.find(id);
        if (order.isPresent()) {
            return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
