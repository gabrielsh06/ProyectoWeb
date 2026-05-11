package com.proyecto.web.sale.dto.response;

import com.proyecto.web.domain.Sale;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SaleResponse(
        Long id,
        LocalDateTime date,
        BigDecimal total,
        String customerName,
        List<SaleDetailResponse> details) {
    public SaleResponse(Sale sale) {
        this(
                sale.getId(),
                sale.getDate(),
                sale.getTotal(),
                sale.getCustomer() != null
                        ? sale.getCustomer().getFirstName() + " " + sale.getCustomer().getLastName()
                        : "Sin cliente",
                sale.getDetails().stream().map(SaleDetailResponse::new).toList());
    }
}