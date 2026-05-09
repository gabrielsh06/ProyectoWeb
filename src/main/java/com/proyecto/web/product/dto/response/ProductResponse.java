package com.proyecto.web.product.dto.response;

import com.proyecto.web.supplier.dto.response.SupplierShortResponse;

public record ProductResponse(
        Long id,
        String code,
        String name,
        String category,
        Double purchasePrice,
        Double salePrice,
        Integer stock,
        SupplierShortResponse supplier
) {
}