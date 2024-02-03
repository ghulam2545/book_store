package com.ghulam.store.dtos;

import com.ghulam.store.enums.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record BookRequestDto(
        @NotBlank(message = "Title is required.")
        String title,

        @NotBlank(message = "At least one author is required.")
        Set<String> authors,

        @Size(max = 500, message = "Description cannot exceed 200 characters.")
        String description,
        Genre genre,

        @NotBlank(message = "ISBN is required.")
        @Pattern(regexp = "\\d{13}", message = "ISBN must be a 13-digit number.")
        String Isbn,
        String publisher,

        @Positive(message = "Price must be positive.")
        long price
) {
}
