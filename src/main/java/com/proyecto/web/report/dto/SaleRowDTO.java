package com.proyecto.web.report.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleRowDTO {
    private Long saleId;
    private String date;
    private String customerName;
    private BigDecimal total;
    private List<SaleItemDTO> items;
}