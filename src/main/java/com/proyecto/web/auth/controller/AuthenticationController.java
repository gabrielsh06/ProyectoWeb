package com.proyecto.web.auth.controller;

import com.proyecto.web.auth.dto.request.LoginRequest;
import com.proyecto.web.auth.dto.response.LoginResponse;
import com.proyecto.web.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthService authService;

    public AuthenticationController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {

        LoginResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}