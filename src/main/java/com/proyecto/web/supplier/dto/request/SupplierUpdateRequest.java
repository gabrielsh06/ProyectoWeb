package com.proyecto.web.supplier.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.web.domain.SupplierStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;


public record SupplierUpdateRequest(

        @NotBlank(message = "El nombre no puede estar en blanco")
        String supplierName,
        @NotBlank(message = "La fecha no puede estar en blanco")
        @PastOrPresent
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dateLastOrder,
        @NotBlank(message = "El estado no puede estar en blanco")
        SupplierStatus paymentStatus,
        @NotBlank(message = "La deuda no puede estar en blanco")
        String debt
) {
}