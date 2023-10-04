package com.myapp.customerservice.dto;

import com.myapp.customerservice.model.TeamModel;

public record TeamDTO(Long id, Long idCustomer, Long idTeamType, Boolean served) {
    public TeamDTO(TeamModel team) {
        this(team.getId(), team.getIdOperator(), team.getIdTeamType(), team.getDeleted());
    }
}
