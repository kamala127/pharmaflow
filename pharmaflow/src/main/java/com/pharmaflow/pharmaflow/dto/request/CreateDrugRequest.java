package com.pharmaflow.pharmaflow.dto.request;

import lombok.Data;

@Data
public class CreateDrugRequest {
    private String name;
    private String manufacturer;
    private String category;
    private String description;
}
