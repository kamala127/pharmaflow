package com.pharmaflow.pharmaflow.controller;

import com.pharmaflow.pharmaflow.dto.request.CreateBatchRequest;
import com.pharmaflow.pharmaflow.dto.response.BatchResponse;
import com.pharmaflow.pharmaflow.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/batch")
    public ResponseEntity<BatchResponse> addBatch(@RequestBody CreateBatchRequest request) {
        return ResponseEntity.ok(inventoryService.addBatch(request));
    }

    @GetMapping("/drug/{drugId}")
    public ResponseEntity<List<BatchResponse>> getByDrug(@PathVariable Long drugId) {
        return ResponseEntity.ok(inventoryService.getBatchesByDrug(drugId));
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<BatchResponse>> lowStock() {
        return ResponseEntity.ok(inventoryService.getLowStock());
    }

    @GetMapping("/expired")
    public ResponseEntity<List<BatchResponse>> expired() {
        return ResponseEntity.ok(inventoryService.getExpiredBatches());
    }

    @PutMapping("/batch/{id}")
    public ResponseEntity<BatchResponse> update(
            @PathVariable Long id,
            @RequestBody CreateBatchRequest request) {
        return ResponseEntity.ok(inventoryService.updateBatch(id, request));
    }
}
