package com.proyecto.web.product.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductUpdateRequest(

        @NotBlank(message = "El nombre no puede estar en blanco")
        String name,
        @NotBlank(message = "La categoria no puede estar en blanco")
        String category,
        BigDecimal purchasePrice,
        BigDecimal salePrice,
        Integer stock,
        Long supplierId
) {
}