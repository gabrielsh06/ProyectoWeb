package com.proyecto.web.auth.dto.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

        @NotBlank(message = "El nombre de usuario no puede estar en blanco")
        String username,
        @NotBlank(message = "La contraseña no puede estar en blanco")
        String password
) {
}