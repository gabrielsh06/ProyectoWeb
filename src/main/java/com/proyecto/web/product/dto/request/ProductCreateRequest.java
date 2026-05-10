package com.proyecto.web.product.dto.request;

import com.proyecto.web.domain.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductCreateRequest(

        @NotNull(message = "El nombre no puede estar en blanco")
        String name,
        @NotBlank(message = "La categoria no puede estar en blanco")
        String category,
        BigDecimal purchasePrice,
        BigDecimal salePrice,
        Integer stock,
        Long supplierId
) {
        public Product toEntity() {
                Product product = new Product();
                product.setName(name);
                product.setCategory(category);
                product.setPurchasePrice(purchasePrice);
                product.setSalePrice(salePrice);
                product.setStock(stock);
                return product;
        }
}