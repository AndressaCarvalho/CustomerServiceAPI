package com.myapp.customerservice.dto;

import com.myapp.customerservice.model.RequestModel;

public record RequestDTO(Long id, Long idOperator, Long idCustomer, Long idTeamType, Boolean finished) {
    public RequestDTO(RequestModel request) {
        this(request.getId(), request.getIdOperator(), request.getIdCustomer(), request.getIdTeamType(), request.getFinished());
    }
}
