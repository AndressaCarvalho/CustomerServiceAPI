package com.myapp.customerservice.dto;

import com.myapp.customerservice.model.QueueModel;

public record QueueDTO(Long id, Long idCustomer, Long idTeamType, Boolean served) {
    public QueueDTO(QueueModel queue) {
        this(queue.getId(), queue.getIdCustomer(), queue.getIdTeamType(), queue.getServed());
    }
}
