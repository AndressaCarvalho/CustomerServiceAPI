package com.myapp.customerservice.repository;

import com.myapp.customerservice.model.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<RequestModel, Long> {
    List<RequestModel> findByIdOperatorAndFinished(Long idOperator, Boolean finished);
}
