package com.pharmaflow.pharmaflow.serviceImpl;

import com.pharmaflow.pharmaflow.dto.request.CreateDrugRequest;
import com.pharmaflow.pharmaflow.dto.response.DrugResponse;
import com.pharmaflow.pharmaflow.entity.Drugs;
import com.pharmaflow.pharmaflow.exception.ResourceNotFoundException;
import com.pharmaflow.pharmaflow.repository.DrugRepository;
import com.pharmaflow.pharmaflow.service.DrugService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DrusServiceImpl implements DrugService {

    private final DrugRepository drugRepository;


    @Override
    public DrugResponse createDrug(CreateDrugRequest request){
        log.info("Creating drug: {}", request.getName());
        Drugs drug = new Drugs();
        drug.setDrugName(request.getName());
        drug.setManufacturer(request.getManufacturer());
        drug.setCategory(request.getCategory());
        drug.setDescription(request.getDescription());
        drugRepository.save(drug);
        log.info("Drug created with id: {}", drug.getId());
        return new DrugResponse(
                drug.getId(),
                drug.getDrugName(),
                drug.getManufacturer(),
                drug.getCategory(),
                drug.getDescription()
        );
    }

    @Override
    public List<DrugResponse> getAllDrugs(){
        log.info("Fetching all drugs");
        return drugRepository.findAll().stream()
                .map(d->new DrugResponse(
                        d.getId(),
                        d.getDrugName(),
                        d.getManufacturer(),
                        d.getCategory(),
                        d.getDescription()
                ))
                .toList();
    }

    @Override
    public DrugResponse getDrugById(Long id){
        log.info("Fetching Drug By: {}",id);

        Drugs drug = drugRepository.findById(id)
                .orElseThrow(()->{
                        log.error("Drug not found By : {}",id);
                         return new ResourceNotFoundException("Drug not found");
                        });

        return new DrugResponse(
                drug.getId(),
                drug.getDrugName(),
                drug.getManufacturer(),
                drug.getCategory(),
                drug.getDescription()
        );
    }

    @Override
    public DrugResponse updateDrug(Long id, CreateDrugRequest request){
        log.info("Drug Updating by: {}",id);
        Drugs drug = drugRepository.findById(id)
                .orElseThrow(()->{
                    log.error("Drug not found By: {}",id);
                    return new ResourceNotFoundException("Drug not found");
                });

        drug.setDrugName(request.getName());
        drug.setCategory(request.getCategory());
        drug.setManufacturer(request.getManufacturer());
        drug.setDescription(request.getDescription());
        drugRepository.save(drug);
        return new DrugResponse(
                drug.getId(),
                drug.getDrugName(),
                drug.getManufacturer(),
                drug.getCategory(),
                drug.getDescription());
    }

    @Override
    public void deleteDrug(Long id) {

        if (!drugRepository.existsById(id)) {
            throw new ResourceNotFoundException("Drug not found");
        }

        drugRepository.deleteById(id);

        log.info("Drug deleted with id: {}", id);
    }

}
