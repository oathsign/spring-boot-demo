package com.oathsign.example.demain;


import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerRepository extends Repository<Customer, String> {
    List<Customer> findByName(String name);

    void save(Customer customer);
}
