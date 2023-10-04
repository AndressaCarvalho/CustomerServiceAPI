package com.myapp.customerservice.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "request")
@Entity(name = "request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RequestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="idoperator")
    private Long idOperator;
    @Column(name="idcustomer")
    private Long idCustomer;
    @Column(name="idteamtype")
    private Long idTeamType;
    private Boolean finished;

    public RequestModel(Long idOperator, Long idCustomer, Long idTeamType, Boolean finished) {
        this.idOperator = idOperator;
        this.idCustomer = idCustomer;
        this.idTeamType = idTeamType;
        this.finished = finished;
    }

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

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getIdTeamType() {
        return idTeamType;
    }

    public void setIdTeamType(Long idTeamType) {
        this.idTeamType = idTeamType;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}
