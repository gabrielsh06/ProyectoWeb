package com.proyecto.web.user.service;

import com.proyecto.web.user.dto.request.UserCreateRequest;
import com.proyecto.web.user.dto.response.UserResponse;
import com.proyecto.web.user.dto.request.UserUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public UserResponse getUser(Long id) {
        return null;
    }

    public List<UserResponse> getAllUsers() {

        return null;
    }

    public UserResponse registerUser(UserCreateRequest userCreateRequest) {

        return null;
    }

    public UserResponse updateUser(Long id, UserUpdateRequest userUpdateRequest) {

        return null;
    }

    public void deleteUser(Long id) {

    }
}