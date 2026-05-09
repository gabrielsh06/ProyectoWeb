package com.proyecto.web.product.dto.request;

public record ProductCreateRequest(
        String name,
        String category,
        Double purchasePrice,
        Double salePrice,
        Integer stock,
        Long supplierId
) {
}