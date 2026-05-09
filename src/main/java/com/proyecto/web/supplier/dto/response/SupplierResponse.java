package com.proyecto.web.supplier.dto.response;

import com.proyecto.web.domain.SupplierStatus;

import java.sql.Date;

public record SupplierResponse(

        Long id,
        String supplierName,
        Date dateLastOrder,
        SupplierStatus paymentStatus,
        String debt
) {
}