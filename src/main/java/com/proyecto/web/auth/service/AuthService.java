package com.proyecto.web.auth.service;

import com.proyecto.web.auth.dto.request.LoginRequest;
import com.proyecto.web.auth.dto.response.LoginResponse;
import com.proyecto.web.auth.repository.AuthRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        return authRepository.findByUsernameAndPassword(loginRequest.username(), loginRequest.password())
                .map(LoginResponse::new)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o contraseña incorrectos"));
    }
}