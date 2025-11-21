package com.example.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateRequest (
    @NotBlank(message = "Email is required") @Email String email,
    @NotBlank(message = "Name is required") @Size(min = 2, max = 40, message = "Name must be 2-40 characters") String name) {

}
