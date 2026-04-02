package com.pharmaflow.pharmaflow.controller;

import com.pharmaflow.pharmaflow.dto.request.CreateDrugRequest;
import com.pharmaflow.pharmaflow.dto.response.DrugResponse;
import com.pharmaflow.pharmaflow.service.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drug")
@RequiredArgsConstructor
public class DrugController {

    private final DrugService drugService;

    @PostMapping("/create-drug")
    public ResponseEntity<DrugResponse> creatDrug(@RequestBody CreateDrugRequest request){
      return ResponseEntity.ok(drugService.createDrug(request));
    }

    @GetMapping("/get-All-drugs")
    public ResponseEntity<List<DrugResponse>> getAllDrugs(){
        return ResponseEntity.ok(drugService.getAllDrugs());
    }

    @GetMapping("/get-drug/{id}")
    public ResponseEntity<DrugResponse> getDrugbyId(@PathVariable Long id){
        return ResponseEntity.ok(drugService.getDrugById(id));
    }

    @PutMapping("/update-drug/{id}")
    public ResponseEntity<DrugResponse> updateDrugbyId(@PathVariable Long id,@RequestBody CreateDrugRequest request){
        return ResponseEntity.ok(drugService.updateDrug(id,request));
    }

    @DeleteMapping("/delete-drug/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        drugService.deleteDrug(id);
        return ResponseEntity.ok("Drug deleted successfully");
    }


}
