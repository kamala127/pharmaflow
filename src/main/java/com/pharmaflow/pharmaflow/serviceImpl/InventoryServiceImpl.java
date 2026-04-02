package com.pharmaflow.pharmaflow.serviceImpl;

import com.pharmaflow.pharmaflow.dto.request.CreateBatchRequest;
import com.pharmaflow.pharmaflow.dto.response.BatchResponse;
import com.pharmaflow.pharmaflow.entity.Batches;
import com.pharmaflow.pharmaflow.entity.Drugs;
import com.pharmaflow.pharmaflow.exception.ResourceNotFoundException;
import com.pharmaflow.pharmaflow.repository.BatchRepository;
import com.pharmaflow.pharmaflow.repository.DrugRepository;
import com.pharmaflow.pharmaflow.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {


    private final BatchRepository batchRepository;
    private final DrugRepository drugRepository;

    // Add Batch

    @Override
    public BatchResponse addBatch(CreateBatchRequest request) {

        log.info("Adding batch for drugId: {}", request.getDrugId());

        Drugs drug = drugRepository.findById(request.getDrugId())
                .orElseThrow(() -> new ResourceNotFoundException("Drug not found"));

        Batches batch = new Batches();
        batch.setDrugs(drug);
        batch.setBatchNumber(request.getBatchNumber());
        batch.setQuantity(request.getQuantity());
        batch.setExpiryDate(request.getExpiryDate());
        batch.setWarehouse(request.getWarehouse());

        batchRepository.save(batch);

        return map(batch);
    }

    @Override
    public List<BatchResponse> getBatchesByDrug(Long drugId) {

        return batchRepository.findByDrugsId(drugId)
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public List<BatchResponse> getLowStock() {

        int threshold = 10; // you can configure later

        return batchRepository.findByQuantityLessThan(threshold)
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public List<BatchResponse> getExpiredBatches() {

        return batchRepository.findByExpiryDateBefore(LocalDate.now())
                .stream()
                .map(this::map)
                .toList();
    }

    @Override
    public BatchResponse updateBatch(Long id, CreateBatchRequest request) {

        Batches batch = batchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Batch not found"));

        batch.setQuantity(request.getQuantity());
        batch.setExpiryDate(request.getExpiryDate());
        batch.setWarehouse(request.getWarehouse());

        batchRepository.save(batch);

        return map(batch);
    }

    private BatchResponse map(Batches batch) {
        return new BatchResponse(
                batch.getId(),
                batch.getDrugs().getId(),
                batch.getBatchNumber(),
                batch.getQuantity(),
                batch.getExpiryDate(),
                batch.getWarehouse()
        );
    }
}
