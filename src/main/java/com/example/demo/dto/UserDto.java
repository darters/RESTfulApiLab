package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto (
    @NotBlank(message = "Email is required") @Email(message = "Email must be valid") String email, 
    @NotBlank(message = "Name is required") String name) {
}
