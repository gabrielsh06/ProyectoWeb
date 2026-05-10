package com.proyecto.web.product.dto.response;

import com.proyecto.web.domain.Product;

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
    public ProductResponse(Product product) {
        this(product.getId(),
                product.getCode(),
                product.getName(),
                product.getCategory(),
                product.getPurchasePrice(),
                product.getSalePrice(),
                product.getStock(),
                product.getSupplier() != null
                        ? new SupplierShortResponse(product.getSupplier())
                        : null);
    }
}