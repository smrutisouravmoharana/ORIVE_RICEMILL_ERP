package com.orive.GatePass.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.GatePass.Dto.VechicleEntryPassDto;
import com.orive.GatePass.Service.VechicleEntryPassService;


@RestController
@RequestMapping(value = "gatepass")
public class VechicleEntryPassController {

	private Logger logger=LoggerFactory.getLogger(VechicleEntryPassController.class);

	@Autowired
	private VechicleEntryPassService vechicleEntryPassService;
	
	// Create a new supplier
    @PostMapping("/create/vechicleEntryPass")
    public ResponseEntity<VechicleEntryPassDto> createVechicleEntryPass(@RequestBody VechicleEntryPassDto supplierDTO) {
        VechicleEntryPassDto createdSupplier = vechicleEntryPassService.createVechicleEntryPass(supplierDTO);
        logger.info("Created supplier with name: {}", createdSupplier.getTransporterName());
        return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
    }

    // Get all suppliers
    @GetMapping("/get/vechicleEntryPass")
    public ResponseEntity<List<VechicleEntryPassDto>> getAllVechicleEntryPass() {
        List<VechicleEntryPassDto> suppliers = vechicleEntryPassService.getAllVechicleEntryPass();
        logger.info("Retrieved {} suppliers from the database", suppliers.size());
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    // Get supplier by ID
    @GetMapping("/get/{vechicleEntryPassId}")
    public ResponseEntity<VechicleEntryPassDto> getVechicleEntryPassById(@PathVariable Long vechicleEntryPassId) {
        Optional<VechicleEntryPassDto> supplier = vechicleEntryPassService.getVechicleEntryPassById(vechicleEntryPassId);
        if (supplier.isPresent()) {
            logger.info("Retrieved supplier with ID: {}", vechicleEntryPassId);
            return new ResponseEntity<>(supplier.get(), HttpStatus.OK);
        } else {
            logger.warn("Supplier with ID {} not found", vechicleEntryPassId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update supplier by ID
    @PutMapping("/update/{vechicleEntryPassId}")
    public ResponseEntity<VechicleEntryPassDto> updateVechicleEntryPass(@PathVariable Long vechicleEntryPassId, @RequestBody VechicleEntryPassDto updatedSupplierDTO) {
        VechicleEntryPassDto updatedSupplier = vechicleEntryPassService.updateVechicleEntryPass(vechicleEntryPassId, updatedSupplierDTO);
        if (updatedSupplier != null) {
            logger.info("Updated supplier with ID: {}", vechicleEntryPassId);
            return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
        } else {
            logger.warn("Supplier with ID {} not found for update", vechicleEntryPassId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
    // Delete supplier by ID
    @DeleteMapping("/delete/{vechicleEntryPassId}")
    public ResponseEntity<Void> deleteVechicleEntryPass(@PathVariable Long vechicleEntryPassId) {
    	vechicleEntryPassService.deleteVechicleEntryPass(vechicleEntryPassId);
        logger.info("Deleted supplier with ID: {}", vechicleEntryPassId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/vechicleEntryPass")
	    public long countVechicleEntryPass()
	    {
	    	return vechicleEntryPassService.countVechicleEntryPass();
	    }
}
