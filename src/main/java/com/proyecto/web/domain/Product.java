package com.proyecto.web.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String category;
    private Double purchasePrice;
    private Double salePrice;
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    private Boolean state;
}