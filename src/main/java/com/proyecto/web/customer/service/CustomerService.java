package com.proyecto.web.customer.service;

import com.proyecto.web.customer.dto.request.CustomerCreateRequest;
import com.proyecto.web.customer.dto.response.CustomerResponse;
import com.proyecto.web.customer.dto.request.CustomerUpdateRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public CustomerResponse findById(Long id) {

        return null;
    }

    public CustomerResponse register(CustomerCreateRequest customerCreateRequest) {

        return null;
    }

    public CustomerResponse update(Long id, CustomerUpdateRequest customerUpdateRequest) {

        return null;
    }

    public void delete(Long id) {

    }
}