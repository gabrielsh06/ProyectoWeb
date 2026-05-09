package com.proyecto.web.customer.service;

import com.proyecto.web.customer.dto.request.CustomerCreateRequest;
import com.proyecto.web.customer.dto.response.CustomerResponse;
import com.proyecto.web.customer.dto.request.CustomerUpdateRequest;
import com.proyecto.web.customer.repository.CustomerRepository;
import com.proyecto.web.domain.Customer;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public  CustomerResponse getCustomer(Long id) {

        return customerRepository.findById(id)
                .filter(Customer::getState)
                .map(CustomerResponse::new)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    public List<CustomerResponse> getAllCustomers() {

        return customerRepository.findAllByStateTrue().stream()
                .map(CustomerResponse::new)
                .toList();
    }

    public CustomerResponse register(CustomerCreateRequest customerCreateRequest) {

        Customer customer = customerCreateRequest.toEntity();
        String code = "CUST-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        customer.setCode(code);
        customer.setState(true);

        return new CustomerResponse(customerRepository.save(customer));
    }

    public CustomerResponse update(Long id, CustomerUpdateRequest customerUpdateRequest) {

        Customer customer = customerRepository.findById(id)
                .filter(Customer::getState)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
        customer.setFirstName(customerUpdateRequest.firstName());
        customer.setLastName(customerUpdateRequest.lastname());

        return new CustomerResponse(customerRepository.save(customer));
    }

    public void delete(Long id) {

        Customer customer = customerRepository.findById(id)
                .filter(Customer::getState)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        customer.setState(false);
        customerRepository.save(customer);
    }
}