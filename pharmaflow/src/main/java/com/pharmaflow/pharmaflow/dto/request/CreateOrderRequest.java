package com.pharmaflow.pharmaflow.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    private Long distributorId;
    private List<OrderItemRequest> items;
}
