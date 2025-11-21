package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.response.UserCreateResponse;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.dto.response.UserUpdateResponse;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        Page<UserResponse> allUsers = userService.getUsers(page, size, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable long id) {
        UserResponse userResponse = userService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @PostMapping
    public ResponseEntity<UserCreateResponse> add(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        UserCreateResponse userCreateResponse = userService.save(userCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreateResponse);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<UserUpdateResponse> update(@PathVariable long id, @Valid @RequestBody UserUpdateRequest userUpdateRequest) {
        UserUpdateResponse userUpdateResponse = userService.update(id, userUpdateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(userUpdateResponse);
    }
}
