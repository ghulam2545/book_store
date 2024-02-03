package com.ghulam.store.dtos.request;

import com.ghulam.store.enums.State;
import jakarta.validation.constraints.*;

public record AddressRequestDto(
        String buildingNumber,

        @NotBlank(message = "Street name is required.")
        String streetName,

        String village,

        @NotBlank(message = "Town name is required.")
        String town,

        @NotBlank(message = "City name is required.")
        String city,

        @NotNull(message = "State is required.")
        State state,

        @NotBlank(message = "Pincode is required.")
        @Size(min = 6, max = 6, message = "Pincode must be 6 digits long.")
        String pincode
) {
}
