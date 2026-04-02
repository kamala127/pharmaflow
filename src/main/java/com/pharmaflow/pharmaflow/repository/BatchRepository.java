package com.pharmaflow.pharmaflow.repository;

import com.pharmaflow.pharmaflow.entity.Batches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batches, Long> {

        List<Batches> findByDrugsId(Long drugId);

        List<Batches> findByQuantityLessThan(int quantity);

        List<Batches> findByExpiryDateBefore(LocalDate date);
}
