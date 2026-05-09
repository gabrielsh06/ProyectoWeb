package com.proyecto.web.supplier.dto.request;

import com.proyecto.web.domain.Supplier;
import jakarta.validation.constraints.NotBlank;

public record SupplierCreateRequest(

        @NotBlank(message = "El nombre no puede estar en blanco")
        String supplierName
) {
        public Supplier toEntity() {
                Supplier supplier = new Supplier();
                supplier.setSupplierName(supplierName);
                return supplier;
        }
}
