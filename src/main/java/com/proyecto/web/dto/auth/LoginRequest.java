package com.proyecto.web.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "El nombre no puede estar en blanco")
        String username,
        @NotBlank(message = "La contraseña no puede estar en blanco")
        String password
) {
}