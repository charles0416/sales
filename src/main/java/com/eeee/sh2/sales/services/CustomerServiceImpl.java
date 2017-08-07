package com.eeee.sh2.sales.services;

import com.eeee.sh2.sales.model.Customer;
import com.eeee.sh2.sales.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Charles on 28/07/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> saveAll(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public Optional<Customer> find(Long id) {
        Customer c = null;
        try {
            c = customerRepository.getOne(id);
        } catch (Exception e) {
            Optional.empty();
        }
        return Optional.ofNullable(c);
    }
}
