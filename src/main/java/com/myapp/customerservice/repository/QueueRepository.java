package com.myapp.customerservice.repository;

import com.myapp.customerservice.model.QueueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends JpaRepository<QueueModel, Long> {
}
