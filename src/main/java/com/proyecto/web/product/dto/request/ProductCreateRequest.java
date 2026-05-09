package com.proyecto.web.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductCreateRequest(

        @NotNull(message = "El nombre no puede estar en blanco")
        String name,
        @NotBlank(message = "La categoria no puede estar en blanco")
        String category,
        @NotBlank(message = "El precio de compra no puede estar en blanco")
        BigDecimal purchasePrice,
        @NotBlank(message = "El precio de venta no puede estar en blanco")
        BigDecimal salePrice,
        @NotBlank(message = "El stock no puede estar en blanco")
        Integer stock,
        @NotBlank(message = "EL proveedor no puede estar en blanco")
        Long supplierId
) {
}