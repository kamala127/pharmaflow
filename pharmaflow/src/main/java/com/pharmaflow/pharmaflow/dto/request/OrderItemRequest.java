package com.pharmaflow.pharmaflow.dto.request;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Long drugId;
    private Long batchId;
    private int quantity;
}
