package com.proyecto.web.auth.service;

import com.proyecto.web.auth.dto.request.LoginRequest;
import com.proyecto.web.auth.dto.response.LoginResponse;
import com.proyecto.web.auth.repository.AuthRepository;
import com.proyecto.web.domain.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        User user = authRepository.findByUsernameAndPassword(loginRequest.username(), loginRequest.password())
                .orElseThrow(() -> new RuntimeException("Username or password incorrect"));
         return new LoginResponse(user);
    }
}