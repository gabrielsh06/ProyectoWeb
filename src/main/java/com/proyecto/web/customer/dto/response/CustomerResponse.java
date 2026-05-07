package com.proyecto.web.customer.dto.response;

import com.proyecto.web.model.Customer;

public record CustomerResponse(

        Long id,
        String code,
        String fullName
) {
    public CustomerResponse(Customer customer){
        this(customer.getId(),
                customer.getCode(),
                customer.getFirstName() + " " + customer.getLastName());
    }
}