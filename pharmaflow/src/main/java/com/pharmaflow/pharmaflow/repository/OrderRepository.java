package com.pharmaflow.pharmaflow.repository;

import com.pharmaflow.pharmaflow.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}
