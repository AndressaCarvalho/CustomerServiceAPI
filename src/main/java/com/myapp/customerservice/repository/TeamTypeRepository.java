package com.myapp.customerservice.repository;

import com.myapp.customerservice.model.TeamTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamTypeRepository extends JpaRepository<TeamTypeModel, Long> {
    TeamTypeModel findByIdSubject(Long idSubject);
}
