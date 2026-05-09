package com.proyecto.web.supplier.dto.response;

import com.proyecto.web.domain.SupplierStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SupplierResponse(

        Long id,
        String supplierName,
        LocalDate dateLastOrder,
        SupplierStatus paymentStatus,
        BigDecimal debt
) {
}