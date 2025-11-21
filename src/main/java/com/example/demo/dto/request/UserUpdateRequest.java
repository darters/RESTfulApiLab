package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record UserUpdateRequest(
    @NotBlank(message = "Email is required") @Email String email,
    @NotBlank(message = "Name is required") String name,
    @PositiveOrZero int balance) {
}
