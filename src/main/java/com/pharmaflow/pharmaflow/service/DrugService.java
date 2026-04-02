package com.pharmaflow.pharmaflow.service;

import com.pharmaflow.pharmaflow.dto.request.CreateDrugRequest;
import com.pharmaflow.pharmaflow.dto.response.DrugResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DrugService {

    DrugResponse createDrug(CreateDrugRequest request);
    List<DrugResponse> getAllDrugs();
    DrugResponse getDrugById(Long id);
    DrugResponse updateDrug(Long id, CreateDrugRequest request);
    void deleteDrug(Long id);
}
