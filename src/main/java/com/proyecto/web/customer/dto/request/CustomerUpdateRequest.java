package com.proyecto.web.customer.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CustomerUpdateRequest(

        @NotBlank(message = "El nombre no puede estar en blanco")
        String firstName,
        @NotBlank(message = "El apellido no puede estar en blanco")
        String lastname
) {
}
