package com.proyecto.web.supplier.dto.request;

import com.proyecto.web.domain.SupplierStatus;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

public record SupplierUpdateRequest(

        @NotBlank(message = "El nombre no puede estar en blanco")
        String supplierName,
        @NotBlank(message = "La fecha no puede estar en blanco")
        Date dateLastOrder,
        @NotBlank(message = "El estado no puede estar en blanco")
        SupplierStatus paymentStatus,
        @NotBlank(message = "La deuda no puede estar en blanco")
        String debt
) {
}