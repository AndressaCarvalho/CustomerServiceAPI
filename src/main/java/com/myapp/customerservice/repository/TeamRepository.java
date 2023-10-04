package com.myapp.customerservice.repository;

import com.myapp.customerservice.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamModel, Long> {
    List<TeamModel> findByIdTeamTypeAndDeleted(Long idTeamType, Boolean deleted);
}
