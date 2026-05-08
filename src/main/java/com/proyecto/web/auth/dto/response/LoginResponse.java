package com.proyecto.web.auth.dto.response;

import com.proyecto.web.domain.User;

public record LoginResponse(

        Long id,
        String username
) {
    public LoginResponse(User user) {
        this(user.getId(),
                user.getUsername());
    }
}