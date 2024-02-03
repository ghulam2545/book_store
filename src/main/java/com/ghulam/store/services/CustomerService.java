package com.ghulam.store.services;

import com.ghulam.store.models.Customer;

import java.util.List;

public interface CustomerService {

    // CRUD ops
    Customer create(Customer customer);

    Customer read(String customerId);

    Customer update(String customerId, Customer customer);

    void delete(String customerId);

    List<Customer> getAllCustomers();
    
}
