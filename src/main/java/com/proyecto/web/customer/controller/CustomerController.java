package com.proyecto.web.customer.controller;

import com.proyecto.web.customer.dto.request.CustomerCreateRequest;
import com.proyecto.web.customer.dto.response.CustomerResponse;
import com.proyecto.web.customer.dto.request.CustomerUpdateRequest;
import com.proyecto.web.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public  CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> registerCustomer(
            @Valid @RequestBody CustomerCreateRequest customerCreateRequest) {

        CustomerResponse response = customerService.register(customerCreateRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerUpdateRequest customerUpdateRequest) {

        CustomerResponse response = customerService.update(id, customerUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

        customerService.delete(id);
        return ResponseEntity.notFound().build();
    }
}