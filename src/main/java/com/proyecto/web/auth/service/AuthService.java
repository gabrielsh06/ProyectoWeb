package com.proyecto.web.auth.service;

import com.proyecto.web.auth.dto.request.LoginRequest;
import com.proyecto.web.auth.dto.response.LoginResponse;
import com.proyecto.web.auth.repository.AuthRepository;
import com.proyecto.web.domain.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        return authRepository.findByUsernameAndPassword(loginRequest.username(), loginRequest.password())
                .filter(User::getState)
                .map(LoginResponse::new)
                .orElseThrow(() -> new EntityNotFoundException("Username or password incorrect"));
    }
}