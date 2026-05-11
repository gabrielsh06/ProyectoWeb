package com.proyecto.web.report.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TopProductDTO {
    private String name;
    private String category;
    private Long quantity; 
    private BigDecimal subtotal;
}