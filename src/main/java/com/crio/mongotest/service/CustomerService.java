package com.crio.mongotest.service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.mongotest.Repository.CustomerRepository;
import com.crio.mongotest.dtos.Customer;
import com.crio.mongotest.entities.CustomerEntity;

@Service
public class CustomerService {
    
    private final AtomicInteger counter = new AtomicInteger(1);

    @Autowired
    private CustomerRepository customerRepository;

    public Long saveCustomer(Customer customer){

        long id = counter.getAndIncrement();
        String name = customer.getName();
        String email = customer.getEmail();
        customerRepository.save(new CustomerEntity(id,name,email));

        return id;
    }

    public Optional<CustomerEntity> getCustomerById(Long id){
         return customerRepository.findById(id);
    }
}
