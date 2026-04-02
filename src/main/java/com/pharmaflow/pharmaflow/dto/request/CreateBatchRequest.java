package com.pharmaflow.pharmaflow.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateBatchRequest {
    private Long drugId;
    private String batchNumber;
    private int quantity;
    private LocalDate expiryDate;
    private String warehouse;
}
