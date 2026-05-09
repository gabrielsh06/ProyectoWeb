package com.proyecto.web.product.dto.response;

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