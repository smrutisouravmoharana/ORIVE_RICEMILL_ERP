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

import com.orive.Supplier.Dto.CorporateSupplierDto;
import com.orive.Supplier.Dto.CorporateSupplierDto;
import com.orive.Supplier.Dto.CorporateSupplierDto;
import com.orive.Supplier.Dto.CorporateSupplierDto;
import com.orive.Supplier.Entity.CorporateSupplierDetails;
import com.orive.Supplier.Entity.CorporateSupplierDetails;
import com.orive.Supplier.Entity.CorporateSupplierDetails;
import com.orive.Supplier.Entity.CorporateSupplierDetails;
import com.orive.Supplier.Repository.CorporateSupplierRepository;


@Service
public class CorporateSupplierService {

	private Logger logger=LoggerFactory.getLogger(CorporateSupplierService.class);
	
	@Autowired
	private CorporateSupplierRepository corporateSupplierRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public CorporateSupplierDto createCorporateSupplier(CorporateSupplierDto corporateSupplierDto) {
        CorporateSupplierDetails supplierEntity = convertToEntity(corporateSupplierDto);
        CorporateSupplierDetails savedSupplier = corporateSupplierRepository.save(supplierEntity);
        logger.info("Created supplier with ID: {}", savedSupplier.getCorporateSupplierId());
        return convertToDTO(savedSupplier);
    }

    // Read
    public List<CorporateSupplierDto> getAllCorporateSuppliers() {
        List<CorporateSupplierDetails> suppliers = corporateSupplierRepository.findAll();
        logger.info("Retrieved {} suppliers from the database", suppliers.size());
        return suppliers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by supplierId
    public Optional<CorporateSupplierDto> getCorporateSupplierById(Long CorporateSupplierId) {
        Optional<CorporateSupplierDetails> supplier = corporateSupplierRepository.findById(CorporateSupplierId);
        if (supplier.isPresent()) {
            return Optional.of(convertToDTO(supplier.get()));
        } else {
            logger.warn("Supplier with ID {} not found", CorporateSupplierId);
            return Optional.empty();
        }
    }
    
    
 // Fetch suppliers by businessOwnerName
    public List<CorporateSupplierDto> getCorporateSuppliersBySuppliername(String supplierName) {
        Optional<CorporateSupplierDetails> supplierOptional = corporateSupplierRepository.findBySupplierName(supplierName);
        if (supplierOptional.isPresent()) {
            CorporateSupplierDetails supplier = supplierOptional.get();
            List<CorporateSupplierDto> suppliers = corporateSupplierRepository.findBySupplierName(supplierName)
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
    public CorporateSupplierDto updateCorporateSupplier(Long CorporateSupplierId, CorporateSupplierDto updatedSupplierDTO) {
        Optional<CorporateSupplierDetails> existingSupplierOptional = corporateSupplierRepository.findById(CorporateSupplierId);
        if (existingSupplierOptional.isPresent()) {
            CorporateSupplierDetails existingSupplier = existingSupplierOptional.get();
            modelMapper.map(updatedSupplierDTO, existingSupplier);
            CorporateSupplierDetails updatedSupplier = corporateSupplierRepository.save(existingSupplier);
            logger.info("Updated supplier with ID: {}", updatedSupplier.getCorporateSupplierId());
            return convertToDTO(updatedSupplier);
        } else {
            logger.warn("Supplier with ID {} not found for update", CorporateSupplierId);
            return null;
        }
    }
    
    //update list by name
    public CorporateSupplierDto updateCorporateSupplierName(String supplierName, CorporateSupplierDto updatedSupplierDTO) {
        Optional<CorporateSupplierDetails> existingSupplierOptional = corporateSupplierRepository.findBySupplierName(supplierName);
        if (existingSupplierOptional.isPresent()) {
            CorporateSupplierDetails existingSupplier = existingSupplierOptional.get();
            modelMapper.map(updatedSupplierDTO, existingSupplier);
            CorporateSupplierDetails updatedSupplier = corporateSupplierRepository.save(existingSupplier);
            logger.info("Updated supplier with name: {}", updatedSupplier.getSupplierName());
            return convertToDTO(updatedSupplier);
        } else {
            logger.warn("Supplier with name {} not found for update", supplierName);
            return null;
        }
    }


    // Delete
    public void deleteCorporateSupplier(Long CorporateSupplierId) {
        corporateSupplierRepository.deleteById(CorporateSupplierId);
        logger.info("Deleted supplier with ID: {}", CorporateSupplierId);
    }

    //count the total supplierlist
    public long countCorporateSupplier()
	 {
		 return corporateSupplierRepository.count();
	 }
	
	
	
	// Helper method to convert SupplierDTo to SupplierDetails entity
    private CorporateSupplierDetails convertToEntity(CorporateSupplierDto corporateSupplierDto)
    {
    	return modelMapper.map(corporateSupplierDto, CorporateSupplierDetails.class);
    }

    // Helper method to convert SupplierDetails entity to SupplierDTo
    private CorporateSupplierDto convertToDTO(CorporateSupplierDetails corporateSupplierDetails) {
        return modelMapper.map(corporateSupplierDetails, CorporateSupplierDto.class);
    } 
 
   
}
