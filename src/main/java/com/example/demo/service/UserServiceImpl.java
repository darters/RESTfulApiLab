package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.response.UserCreateResponse;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.dto.response.UserUpdateResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream().map(user -> new UserResponse(user.getEmail(), user.getName())).toList();
    }
    @Override
    public UserResponse get(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponse(user.getEmail(), user.getName());
    }
    @Override
    public UserCreateResponse save(UserCreateRequest userCreateRequest) {
        if (userRepository.existsByEmail(userCreateRequest.email())) {
            throw new RuntimeException("User with that email already exists");
        }
        User user = new User(userCreateRequest.email(), userCreateRequest.name());
        User createdUser = userRepository.save(user);
        return new UserCreateResponse(createdUser.getEmail(), createdUser.getName());
    }
    @Override
    public UserUpdateResponse update(long id, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User with that id not exist"));
        user.setName(userUpdateRequest.name());
        User updatedUser = userRepository.save(user);
        return new UserUpdateResponse(updatedUser.getEmail(), updatedUser.getName(), user.getBalance());
    }
}
