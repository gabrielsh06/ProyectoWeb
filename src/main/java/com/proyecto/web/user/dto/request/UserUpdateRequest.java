package com.proyecto.web.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserUpdateRequest(

        @NotBlank(message = "El nombre de usuario no puede estar en blanco")
        String username,
        @NotBlank(message = "El correo no puede estar en blanco")
        @Email(message = "El correo debe estar bien escrito")
        String email,
        @NotBlank(message = "La contraseña no peude estar en blanco")
        String password,
        @NotBlank(message = "El nombre no puede estar en blanco")
        String firstName,
        @NotBlank(message = "El rol no puede estar en blanco")
        String role
) {
}