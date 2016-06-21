package com.oathsign.example.service;

import com.oathsign.example.demain.Customer;
import com.oathsign.example.demain.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(String name, String address) {
        Customer customer = new Customer(name, address);
        if (customerRepository.findByName(name).size() == 0) {
            this.customerRepository.save(customer);
        } else {
            throw new RuntimeException("no!Customer exist!");
        }
    }
}
