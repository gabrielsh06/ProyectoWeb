package com.proyecto.web.user.service;

import com.proyecto.web.domain.User;
import com.proyecto.web.user.dto.request.UserCreateRequest;
import com.proyecto.web.user.dto.response.UserResponse;
import com.proyecto.web.user.dto.request.UserUpdateRequest;
import com.proyecto.web.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUser(Long id) {

        return userRepository.findById(id)
                .filter(User::getState)
                .map(UserResponse::new)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public List<UserResponse> getAllUsers() {

        return userRepository.findAllByStateTrue().stream()
                .map(UserResponse::new)
                .toList();
    }

    public UserResponse registerUser(UserCreateRequest userCreateRequest) {

        User user = userCreateRequest.toEntity();
        return new  UserResponse(userRepository.save(user));
    }

    public UserResponse updateUser(Long id, UserUpdateRequest userUpdateRequest) {

        User user = userRepository.findById(id)
                .filter(User::getState)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setUsername(userUpdateRequest.username());
        user.setEmail(userUpdateRequest.email());
        user.setPassword(userUpdateRequest.password());
        user.setFirstName(userUpdateRequest.firstName());
        user.setRole(userUpdateRequest.role());
        return new UserResponse(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setState(false);
        userRepository.save(user);
    }
}