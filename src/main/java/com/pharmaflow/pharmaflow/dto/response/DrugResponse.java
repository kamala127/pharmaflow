package com.pharmaflow.pharmaflow.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DrugResponse {
    private Long id;
    private String name;
    private String manufacturer;
    private String category;
    private String description;
}
