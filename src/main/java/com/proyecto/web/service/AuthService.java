package com.proyecto.web.service;

import com.proyecto.web.dto.auth.LoginRequest;
import com.proyecto.web.dto.auth.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public LoginResponse login(LoginRequest loginRequest) {
        return new LoginResponse(loginRequest.username());
    }
}