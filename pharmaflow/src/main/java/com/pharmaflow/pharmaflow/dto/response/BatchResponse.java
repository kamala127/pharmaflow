package com.pharmaflow.pharmaflow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BatchResponse {
    private Long id;
    private Long drugId;
    private String batchNumber;
    private int quantity;
    private LocalDate expiryDate;
    private String warehouse;

}
