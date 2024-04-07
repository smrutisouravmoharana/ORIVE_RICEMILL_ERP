package com.orive.Rabi.Controller;

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

import com.orive.Rabi.Dto.FarmerDto;
import com.orive.Rabi.Service.FarmerService;


@RestController
@RequestMapping(value = "/rabifarmer")
@CrossOrigin("*")
public class FarmerController {
	
private static final Logger logger=LoggerFactory.getLogger(FarmerController.class); 
	
	@Autowired
	private FarmerService farmerService  ;
	
	
	//API FOR RabiFarmer
	// Create a new RabiFarmer
    @PostMapping("/create/rabifarmer")
    public ResponseEntity<FarmerDto> createFarmer(@RequestBody FarmerDto farmerDto) {
    	FarmerDto createdFarmer = farmerService.createFarmer(farmerDto);
        logger.info("Created RabiFarmer with name: {}", createdFarmer.getFarmerId());
        return new ResponseEntity<>(createdFarmer, HttpStatus.CREATED);
    }

    // Get all RabiFarmer 
    @GetMapping("/get/rabifarmer")
    public ResponseEntity<List<FarmerDto>> getAllFarmers() {
        List<FarmerDto> farmers = farmerService.getAllFarmers();
        logger.info("Retrieved {} RabiFarmer from the database", farmers.size());
        return new ResponseEntity<>(farmers, HttpStatus.OK);
    }

    // Get RabiFarmer by ID
    @GetMapping("/get/rabi/{farmerId}")
    public ResponseEntity<FarmerDto> getFarmerById(@PathVariable Long farmerId) {
        Optional<FarmerDto> farmer = farmerService.getFarmerId(farmerId);
        if (farmer.isPresent()) {
            logger.info("Retrieved RabiFarmer with ID: {}", farmerId);
            return new ResponseEntity<>(farmer.get(), HttpStatus.OK);
        } else {
            logger.warn("RabiFarmer with ID {} not found", farmerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update RabiFarmer by ID
    @PutMapping("/update/rabi/{farmerId}")
    public ResponseEntity<FarmerDto> updateFarmer(@PathVariable Long farmerId, @RequestBody FarmerDto updatedFarmerDto) {
    	FarmerDto updatedFarmer = farmerService.updateFarmer(farmerId, updatedFarmerDto);
        if (updatedFarmer != null) {
            logger.info("Updated RabiFarmer with ID: {}", farmerId);
            return new ResponseEntity<>(updatedFarmer, HttpStatus.OK);
        } else {
            logger.warn("RabiFarmer with ID {} not found for update", farmerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    


    // Delete RabiFarmer by ID
    @DeleteMapping("/delete/rabi/{farmerId}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable Long farmerId) {
        farmerService.deleteFarmer(farmerId);
        logger.info("Deleted RabiFarmer with ID: {}", farmerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/rabifarmer")
	    public long countFarmer()
	    {
	    	return farmerService.countFarmer();
	    }


}
