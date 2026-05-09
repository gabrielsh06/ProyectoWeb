package com.proyecto.web.product.dto.request;

import com.proyecto.web.supplier.dto.response.SupplierShortResponse;

public record ProductUpdateRequest(
        Long id,
        String name,
        String category,
        Double purchasePrice,
        Double salePrice,
        Integer stock,
        SupplierShortResponse supplier
) {
}