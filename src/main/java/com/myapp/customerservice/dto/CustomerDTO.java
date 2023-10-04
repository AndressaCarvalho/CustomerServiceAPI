package com.myapp.customerservice.dto;

import com.myapp.customerservice.model.CustomerModel;

public record CustomerDTO(Long id, String name, Boolean deleted) {
    public CustomerDTO(CustomerModel customer) {
        this(customer.getId(), customer.getName(), customer.getDeleted());
    }
}
