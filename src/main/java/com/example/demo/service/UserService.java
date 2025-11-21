package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.response.UserCreateResponse;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.dto.response.UserUpdateResponse;

public interface UserService {
    UserCreateResponse save(UserCreateRequest userDto);
    UserResponse get(long id);
    List<UserResponse> getAll();
    UserUpdateResponse update(long id, UserUpdateRequest userUpdateRequest);
}
