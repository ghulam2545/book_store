package com.ghulam.store.converters;

import com.ghulam.store.dtos.response.CustomerResponseDto;
import com.ghulam.store.models.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToDto implements Converter<Customer, CustomerResponseDto> {
    @Override
    public CustomerResponseDto convert(Customer source) {
        return new CustomerResponseDto(
                source.getCustomerId(),
                source.getFirstName(),
                source.getLastName(),
                source.getEmail(),
                source.getUsername(),
                source.getAddress(),
                source.getContactNo()
        );
    }
}
