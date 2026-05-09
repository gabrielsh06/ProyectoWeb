package com.proyecto.web.product.dto.response;

import java.math.BigDecimal;

public record ProductResponse(

        Long id,
        String code,
        String name,
        String category,
        BigDecimal purchasePrice,
        BigDecimal salePrice,
        Integer stock,
        SupplierShortResponse supplier
) {
}