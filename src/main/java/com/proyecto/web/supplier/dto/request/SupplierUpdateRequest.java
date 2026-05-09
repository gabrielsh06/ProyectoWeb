package com.proyecto.web.supplier.dto.request;

import com.proyecto.web.domain.SupplierStatus;

import java.sql.Date;

public record SupplierUpdateRequest(
        String supplierName,
        Date dateLastOrder,
        SupplierStatus paymentStatus,
        String debt
) {
}