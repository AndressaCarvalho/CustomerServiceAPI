package com.myapp.customerservice.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "subject")
@Entity(name = "subject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SubjectModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
