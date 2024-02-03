package com.ghulam.store.controllers;

import com.ghulam.store.converters.CustomerToDto;
import com.ghulam.store.converters.DtoToCustomer;
import com.ghulam.store.dtos.request.CustomerRequestDto;
import com.ghulam.store.dtos.response.CustomerResponseDto;
import com.ghulam.store.models.Customer;
import com.ghulam.store.services.CustomerService;
import com.ghulam.store.utils.Result;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoints.base-url}/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final DtoToCustomer dtoToCustomer;
    private final CustomerToDto customerToDto;

    @PostMapping
    public Result addCustomer(@Valid @RequestBody CustomerRequestDto dto) {
        Customer customer = dtoToCustomer.convert(dto);
        Customer addedCustomer = customerService.create(customer);
        CustomerResponseDto response = customerToDto.convert(addedCustomer);

        return new Result(true, HttpStatus.CREATED,
                "Customer '" + addedCustomer.getFirstName() + " " + addedCustomer.getLastName() + "' has been added successfully.",
                response);
    }

    @GetMapping("/{customerId}")
    public Result getCustomerById(@PathVariable String customerId) {
        Customer customer = customerService.read(customerId);
        CustomerResponseDto response = customerToDto.convert(customer);

        return new Result(true, HttpStatus.OK, "Retrieved customer details for customer ID: " + customerId, response);
    }

    @PutMapping("/{customerId}")
    public Result updateCustomer(@PathVariable String customerId, @Valid @RequestBody CustomerRequestDto dto) {
        Customer customer = dtoToCustomer.convert(dto);
        Customer updatedCustomer = customerService.update(customerId, customer);
        CustomerResponseDto response = customerToDto.convert(updatedCustomer);

        return new Result(true, HttpStatus.OK,
                "Customer details for '" + updatedCustomer.getFirstName() + " " + updatedCustomer.getLastName() + "' have been updated successfully.",
                response);
    }

    @DeleteMapping("/{customerId}")
    public Result deleteCustomer(@PathVariable String customerId) {
        customerService.delete(customerId);

        return new Result(true, HttpStatus.OK, "Customer with ID: " + customerId + " has been removed successfully.");
    }

    @GetMapping
    public Result getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        List<CustomerResponseDto> response = allCustomers.stream().map(customerToDto::convert).toList();

        return new Result(true, HttpStatus.OK, "Retrieved a list of all registered customers.", response);
    }
}
