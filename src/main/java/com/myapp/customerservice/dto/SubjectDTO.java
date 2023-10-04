package com.myapp.customerservice.dto;

import com.myapp.customerservice.model.SubjectModel;

public record SubjectDTO(Long id, String description) {
    public SubjectDTO(SubjectModel subject) {
        this(subject.getId(), subject.getDescription());
    }
}
