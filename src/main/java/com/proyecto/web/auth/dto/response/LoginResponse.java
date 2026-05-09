package com.proyecto.web.auth.dto.response;


public record LoginResponse(

        Long id,
        String username,
        String role
) {
}