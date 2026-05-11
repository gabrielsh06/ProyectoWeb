package com.proyecto.web.report.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ReportDTO {
    private BigDecimal totalSales;
    private Long totalTransactions;
    private BigDecimal averageTicket;
    private List<TopProductDTO> topProducts;
}