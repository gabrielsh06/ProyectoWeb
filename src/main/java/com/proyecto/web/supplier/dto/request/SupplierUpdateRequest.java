package com.proyecto.web.supplier.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyecto.web.domain.SupplierStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;


public record SupplierUpdateRequest(

        @NotBlank(message = "El nombre no puede estar en blanco")
        String supplierName,
        @PastOrPresent
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dateLastOrder,
        SupplierStatus paymentStatus,
        BigDecimal debt
) {
}