package com.pharmaflow.pharmaflow.repository;

import com.pharmaflow.pharmaflow.entity.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drugs, Long> {
}
