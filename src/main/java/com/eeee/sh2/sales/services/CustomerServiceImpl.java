package com.eeee.sh2.sales.services;

import com.eeee.sh2.sales.model.Customer;
import com.eeee.sh2.sales.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Charles on 28/07/2017.
 */
@Service
public class CustomerServiceImpl extends  DefaultDataServiceImpl<Customer> implements CustomerService{

    @Autowired
    CustomerRepository repository;

    @Override
    protected JpaRepository<Customer, Long> getRepository() {
        return repository;
    }

}
