package com.orive.GatePass.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.GatePass.Dto.VechicleEntryPassDto;
import com.orive.GatePass.Entity.VechicleEntryPassEntity;
import com.orive.GatePass.Repository.VechicleEntryPassRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class VechicleEntryPassService {
 
	private Logger logger=LoggerFactory.getLogger(VechicleEntryPassService.class);

	@Autowired
	private VechicleEntryPassRepository vechicleEntryPassRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	private ObjectMapper objectMapper;

    // Create
    public VechicleEntryPassDto createVechicleEntryPass(VechicleEntryPassDto supplierDTO) {
        VechicleEntryPassEntity supplierEntity = convertToEntity(supplierDTO);
        VechicleEntryPassEntity savedSupplier = vechicleEntryPassRepository.save(supplierEntity);
        logger.info("Created supplier with ID: {}", savedSupplier.getVechicleEntryPassId());
        return convertToDTO(savedSupplier);
    }

    // Read
    public List<VechicleEntryPassDto> getAllVechicleEntryPass() {
        List<VechicleEntryPassEntity> suppliers = vechicleEntryPassRepository.findAll();
        logger.info("Retrieved {} suppliers from the database", suppliers.size());
        return suppliers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by supplierId
    public Optional<VechicleEntryPassDto> getVechicleEntryPassById(Long vechicleEntryPassId) {
        Optional<VechicleEntryPassEntity> supplier = vechicleEntryPassRepository.findById(vechicleEntryPassId);
        if (supplier.isPresent()) {
            return Optional.of(convertToDTO(supplier.get()));
        } else {
            logger.warn("Supplier with ID {} not found", vechicleEntryPassId);
            return Optional.empty();
        }
    }
    
    

    // Update list by id
    public VechicleEntryPassDto updateVechicleEntryPass(Long vechicleEntryPassId, VechicleEntryPassDto updatedSupplierDTO) {
        Optional<VechicleEntryPassEntity> existingSupplierOptional = vechicleEntryPassRepository.findById(vechicleEntryPassId);
        if (existingSupplierOptional.isPresent()) {
        	VechicleEntryPassEntity existingSupplier = existingSupplierOptional.get();
            modelMapper.map(updatedSupplierDTO, existingSupplier);
            VechicleEntryPassEntity updatedSupplier = vechicleEntryPassRepository.save(existingSupplier);
            logger.info("Updated supplier with ID: {}", updatedSupplier.getVechicleEntryPassId());
            return convertToDTO(updatedSupplier);
        } else {
            logger.warn("Supplier with ID {} not found for update", vechicleEntryPassId);
            return null;
        }
    }
   
    // Delete
    public void deleteVechicleEntryPass(Long vechicleEntryPassId) {
    	vechicleEntryPassRepository.deleteById(vechicleEntryPassId);
        logger.info("Deleted supplier with ID: {}", vechicleEntryPassId);
    }

    //count the total supplierlist
    public long countVechicleEntryPass()
	 {
		 return vechicleEntryPassRepository.count();
	 }
    
    
    // Helper method to convert SupplierDTo to SupplierDetails entity
    private VechicleEntryPassEntity convertToEntity(VechicleEntryPassDto supplierDTO) {
        return modelMapper.map(supplierDTO, VechicleEntryPassEntity.class);
    }

    // Helper method to convert SupplierDetails entity to SupplierDTo
    private VechicleEntryPassDto convertToDTO(VechicleEntryPassEntity individualSupplierDetails) {
        return modelMapper.map(individualSupplierDetails, VechicleEntryPassDto.class);
    }
}
