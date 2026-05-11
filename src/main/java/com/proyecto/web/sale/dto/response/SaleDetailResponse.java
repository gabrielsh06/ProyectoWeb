package com.proyecto.web.sale.dto.response;

import com.proyecto.web.domain.SaleDetail;
import java.math.BigDecimal;

public record SaleDetailResponse(
        String productCode,
        String productName,
        Integer quantity,
        BigDecimal unitPrice,
        BigDecimal subtotal) {
    public SaleDetailResponse(SaleDetail d) {
        this(
                d.getProduct().getCode(),
                d.getProduct().getName(),
                d.getQuantity(),
                d.getUnitPrice(),
                d.getSubtotal());
    }
}