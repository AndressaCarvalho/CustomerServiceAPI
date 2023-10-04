package com.myapp.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myapp.customerservice.model.OperatorModel;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<OperatorModel, Long> {
}
