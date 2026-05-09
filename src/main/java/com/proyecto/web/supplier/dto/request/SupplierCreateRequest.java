package com.proyecto.web.supplier.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SupplierCreateRequest(

        @NotBlank(message = "El nombre no puede estar en blanco")
        String supplierName
) {
}
