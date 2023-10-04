package com.myapp.customerservice.dto;

import com.myapp.customerservice.model.OperatorModel;

public record OperatorDTO(Long id, String name, Boolean deleted) {
    public OperatorDTO(OperatorModel operator) {
        this(operator.getId(), operator.getName(), operator.getDeleted());
    }
}
