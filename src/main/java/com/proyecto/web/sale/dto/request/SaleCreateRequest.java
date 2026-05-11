package com.proyecto.web.sale.dto.request;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record SaleCreateRequest(
        Long customerId,
        @NotEmpty List<SaleItemRequest> items) {
}