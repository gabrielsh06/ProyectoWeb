package com.proyecto.web.customer.dto.request;

import com.proyecto.web.domain.Customer;
import jakarta.validation.constraints.NotBlank;

public record CustomerCreateRequest(

        @NotBlank(message = "EL nombre no puede estar en blanco")
        String firstName,
        @NotBlank(message = "EL apellido no puede estar en blanco")
        String lastName
) {
        public Customer toEntity() {
            Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            return customer;
        }
}