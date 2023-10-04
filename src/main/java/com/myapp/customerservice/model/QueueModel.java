package com.myapp.customerservice.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "queue")
@Entity(name = "queue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class QueueModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="idcustomer")
    private Long idCustomer;
    @Column(name="idteamtype")
    private Long idTeamType;
    private Boolean served;

    public QueueModel(Long idCustomer, Long idTeamType, Boolean served) {
        this.idCustomer = idCustomer;
        this.idTeamType = idTeamType;
        this.served = served;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getServed() {
        return served;
    }

    public void setServed(Boolean served) {
        this.served = served;
    }
}
