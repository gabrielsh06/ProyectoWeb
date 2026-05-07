package com.proyecto.web.user.dto.request;

public record UserUpdateRequest(

        String username,
        String email,
        String password,
        String firstName,
        String role
) {
}