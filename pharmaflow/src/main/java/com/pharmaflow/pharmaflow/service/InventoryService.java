package com.pharmaflow.pharmaflow.service;

import com.pharmaflow.pharmaflow.dto.request.CreateBatchRequest;
import com.pharmaflow.pharmaflow.dto.response.BatchResponse;
import com.pharmaflow.pharmaflow.dto.response.DrugResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {

    BatchResponse addBatch(CreateBatchRequest request);
    List<BatchResponse> getBatchesByDrug(Long id);
    List<BatchResponse> getLowStock();
    List<BatchResponse> getExpiredBatches();
    BatchResponse updateBatch(Long id, CreateBatchRequest request);

}
