package com.eeee.sh2.sales.services;

import com.eeee.sh2.sales.model.Customer;
import com.eeee.sh2.sales.model.Order;
import com.eeee.sh2.sales.repositories.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Charles on 28/07/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public List<Order> saveAll(List<Order> inputRows) {

        List<Order> result = inputRows.stream().map(input -> this.save(input)).collect(Collectors.toList());
        return result;
    }


    @Override
    public Optional<Order> find(Long id) {
        Order order = null;
        try {
            order = orderRepository.getOne(id);
        } catch (Exception e) {
            Optional.empty();
        }
        return Optional.ofNullable(order);
    }

    @Override
    public Order save(Order order) {
        Order target = order;
        Optional<Order> old = orderRepository.findById(order.getId());
        if (old.isPresent()) {
            Order existing = old.get();
            BeanUtils.copyProperties(order, existing);
            target = existing;
        }

        if (order.getCustomer() != null) {
            Customer c = customerService.save(order.getCustomer());
            target.setCustomer(c);
        }
        return orderRepository.save(target);
    }
}
