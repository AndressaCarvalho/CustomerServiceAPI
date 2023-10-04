package com.myapp.customerservice.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "team")
@Entity(name = "team")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TeamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="idoperator")
    private Long idOperator;
    @Column(name="idteamtype")
    private Long idTeamType;
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOperator() {
        return idOperator;
    }

    public void setIdOperator(Long idOperator) {
        this.idOperator = idOperator;
    }

    public Long getIdTeamType() {
        return idTeamType;
    }

    public void setIdTeamType(Long idTeamType) {
        this.idTeamType = idTeamType;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
