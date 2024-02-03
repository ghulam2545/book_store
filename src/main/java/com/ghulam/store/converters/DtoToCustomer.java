package com.ghulam.store.converters;

import com.ghulam.store.dtos.request.CustomerRequestDto;
import com.ghulam.store.models.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DtoToCustomer implements Converter<CustomerRequestDto, Customer> {

    private final DtoToAddress dtoToAddress;

    @Override
    public Customer convert(CustomerRequestDto source) {
        Customer customer = new Customer();

        customer.setFirstName(source.firstName());
        customer.setLastName(source.lastName());
        customer.setEmail(source.email());
        customer.setUsername(source.username());
        customer.setPassword(source.password());
        customer.setAddress(dtoToAddress.convert(source.address()));
        customer.setContactNo(source.contactNo());

        return customer;
    }
}
