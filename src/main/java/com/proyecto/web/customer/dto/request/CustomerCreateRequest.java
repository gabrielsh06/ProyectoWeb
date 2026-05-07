package com.proyecto.web.customer.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CustomerCreateRequest(

        @NotBlank(message = "EL nombre no puede estar en blanco")
        String firstName,
        @NotBlank(message = "EL apellido no puede estar en blanco")
        String lastName
) {
}