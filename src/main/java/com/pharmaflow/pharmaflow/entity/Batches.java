package com.pharmaflow.pharmaflow.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="batches")
public class Batches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drugs_id", nullable = false)
    private Drugs drugs;

    private String batchNumber;
    private int quantity;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;   // ✅ FIXED

    private String warehouse;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt; // ✅ FIXED

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

}
