package com.proyecto.web.sale.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record SaleItemRequest(
        @NotNull Long productId,
        @Min(1) Integer quantity) {
}