package com.orive.Supplier.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Supplier.Dto.CorporateSupplierDto;
import com.orive.Supplier.Dto.IndividualSupplierDto;
import com.orive.Supplier.Service.CorporateSupplierService;
import com.orive.Supplier.Service.IndividualSupplierService;

@RestController
@RequestMapping(value = "/suppliers")
@CrossOrigin("*")
public class SupplierController {
	
	private Logger logger=LoggerFactory.getLogger(SupplierController.class);

	@Autowired
	private IndividualSupplierService individualSupplierService;
	
	@Autowired
	private CorporateSupplierService corporateSupplierService;
	
	//API FOR INDIVIDUAL SUPPLIER
	// Create a new supplier
    @PostMapping("/create/supplier")
    public ResponseEntity<IndividualSupplierDto> createSupplier(@RequestBody IndividualSupplierDto supplierDTO) {
        IndividualSupplierDto createdSupplier = individualSupplierService.createSupplier(supplierDTO);
        logger.info("Created supplier with name: {}", createdSupplier.getSupplierName());
        return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
    }

    // Get all suppliers
    
    @GetMapping("/get/suppliers")
    public ResponseEntity<List<IndividualSupplierDto>> getAllSuppliers() {
        List<IndividualSupplierDto> suppliers = individualSupplierService.getAllSuppliers();
        logger.info("Retrieved {} suppliers from the database", suppliers.size());
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    // Get supplier by ID
    @GetMapping("/get/{individualSupplierId}")
    public ResponseEntity<IndividualSupplierDto> getSupplierById(@PathVariable Long individualSupplierId) {
        Optional<IndividualSupplierDto> supplier = individualSupplierService.getSupplierById(individualSupplierId);
        if (supplier.isPresent()) {
            logger.info("Retrieved supplier with ID: {}", individualSupplierId);
            return new ResponseEntity<>(supplier.get(), HttpStatus.OK);
        } else {
            logger.warn("Supplier with ID {} not found", individualSupplierId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update supplier by ID
    @PutMapping("/update/{individualSupplierId}")
    public ResponseEntity<IndividualSupplierDto> updateSupplier(@PathVariable Long individualSupplierId, @RequestBody IndividualSupplierDto updatedSupplierDTO) {
        IndividualSupplierDto updatedSupplier = individualSupplierService.updateSupplier(individualSupplierId, updatedSupplierDTO);
        if (updatedSupplier != null) {
            logger.info("Updated supplier with ID: {}", individualSupplierId);
            return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
        } else {
            logger.warn("Supplier with ID {} not found for update", individualSupplierId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Update supplier by Name
    @PutMapping("/update/{supplierName}")
    public ResponseEntity<IndividualSupplierDto> updateSupplierName(@PathVariable String supplierName, @RequestBody IndividualSupplierDto updatedSupplierDTO) {
        IndividualSupplierDto updatedSupplier = individualSupplierService.updateSupplierName(supplierName, updatedSupplierDTO);
        if (updatedSupplier != null) {
            logger.info("Updated supplier with name: {}", supplierName);
            return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
        } else {
            logger.warn("Supplier with name {} not found for update", supplierName);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Delete supplier by ID
    @DeleteMapping("/delete/{individualSupplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long individualSupplierId) {
        individualSupplierService.deleteSupplier(individualSupplierId);
        logger.info("Deleted supplier with ID: {}", individualSupplierId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get suppliers by business owner name
    @GetMapping("/byBusinessOwner/{supplierName}")
    public ResponseEntity<List<IndividualSupplierDto>> getSuppliersByBusinessOwnerName(@PathVariable String supplierName) {
        List<IndividualSupplierDto> suppliers = individualSupplierService.getSuppliersBySuppliername(supplierName);
        if (!suppliers.isEmpty()) {
            logger.info("Retrieved {} suppliers with business owner name: {}", suppliers.size(), supplierName);
            return new ResponseEntity<>(suppliers, HttpStatus.OK);
        } else {
            logger.warn("No suppliers found with business owner name: {}", supplierName);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	    
	    @GetMapping("/count/supplier")
	    public long countSupplier()
	    {
	    	return individualSupplierService.countSupplier();
	    }
	//-------------------------------------------------------------------------------------------------    
	    
	  //API FOR INDIVIDUAL SUPPLIER   
	 // Create a new supplier
	    @PostMapping("/create/corporatesupplier")
	    public ResponseEntity<CorporateSupplierDto> createCorporateSupplier(@RequestBody CorporateSupplierDto supplierDTO) {
	        CorporateSupplierDto createdSupplier =corporateSupplierService.createCorporateSupplier(supplierDTO);
	        logger.info("Created supplier with name: {}", createdSupplier.getSupplierName());
	        return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
	    }

	    // Get all suppliers
	    
	    @GetMapping("/get/corporatesuppliers")
	    public ResponseEntity<List<CorporateSupplierDto>> getAllCorporateSuppliers() {
	        List<CorporateSupplierDto> suppliers = corporateSupplierService.getAllCorporateSuppliers();
	        logger.info("Retrieved {} suppliers from the database", suppliers.size());
	        return new ResponseEntity<>(suppliers, HttpStatus.OK);
	    }  
	   
	    // Get supplier by ID
	    @GetMapping("/get/{corporateSupplierId}")
	    public ResponseEntity<CorporateSupplierDto> getCorporateSupplierById(@PathVariable Long corporateSupplierId) {
	        Optional<CorporateSupplierDto> supplier = corporateSupplierService.getCorporateSupplierById(corporateSupplierId);
	        if (supplier.isPresent()) {
	            logger.info("Retrieved supplier with ID: {}", corporateSupplierId);
	            return new ResponseEntity<>(supplier.get(), HttpStatus.OK);
	        } else {
	            logger.warn("Supplier with ID {} not found", corporateSupplierId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Update supplier by ID
	    @PutMapping("/update/{corporateSupplierId}")
	    public ResponseEntity<CorporateSupplierDto> updateCorporateSupplier(@PathVariable Long corporateSupplierId, @RequestBody CorporateSupplierDto updatedSupplierDTO) {
	        CorporateSupplierDto updatedSupplier = corporateSupplierService.updateCorporateSupplier(corporateSupplierId, updatedSupplierDTO);
	        if (updatedSupplier != null) {
	            logger.info("Updated supplier with ID: {}", corporateSupplierId);
	            return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
	        } else {
	            logger.warn("Supplier with ID {} not found for update", corporateSupplierId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    // Delete supplier by ID
	    @DeleteMapping("/delete/{corporateSupplierId}")
	    public ResponseEntity<Void> deleteCorporateSupplier(@PathVariable Long corporateSupplierId) {
	        individualSupplierService.deleteSupplier(corporateSupplierId);
	        logger.info("Deleted supplier with ID: {}", corporateSupplierId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    //Count Corporate Supplier 
	    @GetMapping("/count/corporatesupplier")
	    public long countCorporateSupplier()
	    {
	    	return corporateSupplierService.countCorporateSupplier();
	    }
	    
}
