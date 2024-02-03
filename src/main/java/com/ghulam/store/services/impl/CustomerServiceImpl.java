package com.ghulam.store.services.impl;

import com.ghulam.store.exceptions.CustomerNotFoundException;
import com.ghulam.store.models.Customer;
import com.ghulam.store.repositories.CustomerRepository;
import com.ghulam.store.services.CustomerService;
import com.ghulam.store.utils.IdGenerator;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepo;

    @Override
    public Customer create(Customer customer) {
        final String id = IdGenerator.next();
        customer.setCustomerId(id);

        return customerRepo.save(customer);
    }

    @Override
    public Customer read(String customerId) {
        return customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer of id: " + customerId + " is not found."));
    }

    @Override
    public Customer update(String customerId, Customer customer) {
        Customer oldCustomer = customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer of id: " + customerId + " is not found."));

        // update data of the customer
        oldCustomer.setFirstName(customer.getCustomerId());
        oldCustomer.setLastName(customer.getLastName());
        // more if
        // todo

        return customerRepo.save(oldCustomer);
    }

    @Override
    public void delete(String customerId) {
        boolean b = customerRepo.existsById(customerId);

        if (b) {
            customerRepo.deleteById(customerId);
        } else {
            throw new CustomerNotFoundException("Customer of id: " + customerId + " is not found.");
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
