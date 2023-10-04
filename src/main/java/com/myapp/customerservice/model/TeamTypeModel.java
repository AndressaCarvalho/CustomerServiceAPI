package com.myapp.customerservice.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "teamtype")
@Entity(name = "teamtype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TeamTypeModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="idsubject")
    private Long idSubject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }
}
