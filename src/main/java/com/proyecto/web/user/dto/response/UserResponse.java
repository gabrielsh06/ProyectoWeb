package com.proyecto.web.user.dto.response;


import com.proyecto.web.domain.User;

public record UserResponse(

        Long id,
        String username,
        String email,
        String firstName,
        String role
) {
    public UserResponse(User user) {
        this(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getRole());
    }
}