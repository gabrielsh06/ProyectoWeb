package com.proyecto.web.user.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserCreateRequest(

        @NotBlank(message = "El nombre de usuario no puede estar en blanco")
        String username,
        String email,
        @NotBlank(message = "La contraseña no puede estar en blanco")
        String password,
        @NotBlank(message = "El nombre no puede estar en blanco")
        String firstName,
        @NotBlank(message = "El rol no puede estar en blanco")
        String role
) {
}