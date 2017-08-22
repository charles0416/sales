package com.eeee.sh2.sales.controllers;

import com.eeee.sh2.sales.model.Order;
import com.eeee.sh2.sales.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Charles on 28/07/2017.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderRestController extends AbstractDataRestController<OrderService, Order> {

    @Autowired
    OrderService orderService;

    @Override
    protected OrderService getService() {
        return this.orderService;
    }
}
