package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.response.UserCreateResponse;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.dto.response.UserUpdateResponse;

public interface UserService {
    UserCreateResponse save(UserCreateRequest userDto);
    UserResponse get(long id);
    Page<UserResponse> getUsers(int page, int size, String sortBy);
    UserUpdateResponse update(long id, UserUpdateRequest userUpdateRequest);
}
