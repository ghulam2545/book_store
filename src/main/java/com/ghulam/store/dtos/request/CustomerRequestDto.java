package com.ghulam.store.dtos.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CustomerRequestDto(
        String firstName,

        @NotBlank(message = "Last name is required.")
        String lastName,

        @NotBlank(message = "Email is required.")
        @Email(message = "Invalid email format.")
        String email,

        @NotBlank(message = "Username is required.")
        @Length(min = 5, max = 20, message = "Username must be between 5 and 20 characters.")
        String username,

        @NotBlank(message = "Password is required.")
        @Length(min = 8, message = "Password must be at least 8 characters.")
        /* @Pattern() // todo */
        String password,

        @NotBlank(message = "Address is required.")
        AddressRequestDto address,

        @NotBlank(message = "Contact number is required.")
        @Pattern(regexp = "\\d{10}", message = "Contact number must be a 10-digit number.")
        String contactNo
) {
}
