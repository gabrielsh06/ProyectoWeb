package com.proyecto.web.customer.controller;

import com.proyecto.web.customer.dto.request.CustomerCreateRequest;
import com.proyecto.web.customer.dto.response.CustomerResponse;
import com.proyecto.web.customer.dto.request.CustomerUpdateRequest;
import com.proyecto.web.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public  CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id) {

        CustomerResponse response = customerService.getCustomer(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {

        List<CustomerResponse> response = customerService.getAllCustomers();
        return ResponseEntity.ok().body(response);
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
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

        customerService.delete(id);
        return ResponseEntity.notFound().build();
    }
}