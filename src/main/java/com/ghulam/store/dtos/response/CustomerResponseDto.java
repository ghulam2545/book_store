package com.ghulam.store.dtos.response;

import com.ghulam.store.models.Address;

public record CustomerResponseDto(
        String customerId,
        String firstName,
        String lastName,
        String email,
        String username,

        // don't reveal customer's password
        // String password,
        Address address,
        String contactNo
) {
}
