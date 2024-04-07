package com.orive.Supplier.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orive.Supplier.Dto.IndividualSupplierDto;
import com.orive.Supplier.Entity.IndividualSupplierDetails;
import com.orive.Supplier.Repository.IndividualSupplierRepositoy;

@Service
public class IndividualSupplierService {
	
	private Logger logger=LoggerFactory.getLogger(IndividualSupplierService.class);

	@Autowired
	private IndividualSupplierRepositoy supplierRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	private ObjectMapper objectMapper;

    // Create
    public IndividualSupplierDto createSupplier(IndividualSupplierDto supplierDTO) {
        IndividualSupplierDetails supplierEntity = convertToEntity(supplierDTO);
        IndividualSupplierDetails savedSupplier = supplierRepository.save(supplierEntity);
        logger.info("Created supplier with ID: {}", savedSupplier.getIndividualSupplierId());
        return convertToDTO(savedSupplier);
    }

    // Read
    public List<IndividualSupplierDto> getAllSuppliers() {
        List<IndividualSupplierDetails> suppliers = supplierRepository.findAll();
        logger.info("Retrieved {} suppliers from the database", suppliers.size());
        return suppliers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by supplierId
    public Optional<IndividualSupplierDto> getSupplierById(Long individualSupplierId) {
        Optional<IndividualSupplierDetails> supplier = supplierRepository.findById(individualSupplierId);
        if (supplier.isPresent()) {
            return Optional.of(convertToDTO(supplier.get()));
        } else {
            logger.warn("Supplier with ID {} not found", individualSupplierId);
            return Optional.empty();
        }
    }
    
    
 // Fetch suppliers by businessOwnerName
    public List<IndividualSupplierDto> getSuppliersBySuppliername(String supplierName) {
        Optional<IndividualSupplierDetails> supplierOptional = supplierRepository.findBySupplierName(supplierName);
        if (supplierOptional.isPresent()) {
            IndividualSupplierDetails supplier = supplierOptional.get();
            List<IndividualSupplierDto> suppliers = supplierRepository.findBySupplierName(supplierName)
                    .stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            logger.info("Retrieved {} suppliers with business owner name: {}", suppliers.size(), supplierName);
            return suppliers;
        } else {
            logger.warn("No suppliers found with business owner name: {}", supplierName);
            return Collections.emptyList();
        }
    }

    // Update list by id
    public IndividualSupplierDto updateSupplier(Long individualSupplierId, IndividualSupplierDto updatedSupplierDTO) {
        Optional<IndividualSupplierDetails> existingSupplierOptional = supplierRepository.findById(individualSupplierId);
        if (existingSupplierOptional.isPresent()) {
            IndividualSupplierDetails existingSupplier = existingSupplierOptional.get();
            modelMapper.map(updatedSupplierDTO, existingSupplier);
            IndividualSupplierDetails updatedSupplier = supplierRepository.save(existingSupplier);
            logger.info("Updated supplier with ID: {}", updatedSupplier.getIndividualSupplierId());
            return convertToDTO(updatedSupplier);
        } else {
            logger.warn("Supplier with ID {} not found for update", individualSupplierId);
            return null;
        }
    }
    
    //update list by name
    public IndividualSupplierDto updateSupplierName(String supplierName, IndividualSupplierDto updatedSupplierDTO) {
        Optional<IndividualSupplierDetails> existingSupplierOptional = supplierRepository.findBySupplierName(supplierName);
        if (existingSupplierOptional.isPresent()) {
            IndividualSupplierDetails existingSupplier = existingSupplierOptional.get();
            modelMapper.map(updatedSupplierDTO, existingSupplier);
            IndividualSupplierDetails updatedSupplier = supplierRepository.save(existingSupplier);
            logger.info("Updated supplier with name: {}", updatedSupplier.getSupplierName());
            return convertToDTO(updatedSupplier);
        } else {
            logger.warn("Supplier with name {} not found for update", supplierName);
            return null;
        }
    }


    // Delete
    public void deleteSupplier(Long individualSupplierId) {
        supplierRepository.deleteById(individualSupplierId);
        logger.info("Deleted supplier with ID: {}", individualSupplierId);
    }

    //count the total supplierlist
    public long countSupplier()
	 {
		 return supplierRepository.count();
	 }
    
    
    // Helper method to convert SupplierDTo to SupplierDetails entity
    private IndividualSupplierDetails convertToEntity(IndividualSupplierDto supplierDTO) {
        return modelMapper.map(supplierDTO, IndividualSupplierDetails.class);
    }

    // Helper method to convert SupplierDetails entity to SupplierDTo
    private IndividualSupplierDto convertToDTO(IndividualSupplierDetails individualSupplierDetails) {
        return modelMapper.map(individualSupplierDetails, IndividualSupplierDto.class);
    }
    
    
	 
	
}
