package com.proyecto.web.product.dto.response;

import com.proyecto.web.domain.Supplier;

public record SupplierShortResponse(
        Long id,
        String supplierName
) {
    public SupplierShortResponse(Supplier supplier) {
        this(supplier.getId(),
                supplier.getSupplierName());
    }
}