package com.orive.Kharif.Controller;

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

import com.orive.Kharif.Dto.FarmerDto;
import com.orive.Kharif.Service.FarmerService;



@RestController
@RequestMapping(value = "/khariffarmer")
@CrossOrigin("*")
public class FarmerController {
	
	
private static final Logger logger=LoggerFactory.getLogger(FarmerController.class); 
	
	@Autowired
	private FarmerService farmerService  ;
	
	
	//API FOR KharifFarmer
	// Create a new KharifFarmer
    @PostMapping("/create/khariffarmer")
    public ResponseEntity<FarmerDto> createFarmer(@RequestBody FarmerDto farmerDto) {
    	FarmerDto createdFarmer = farmerService.createFarmer(farmerDto);
        logger.info("Created KharifFarmer with name: {}", createdFarmer.getFarmerId());
        return new ResponseEntity<>(createdFarmer, HttpStatus.CREATED);
    }

    // Get all KharifFarmer 
    @GetMapping("/get/khariffarmer")
    public ResponseEntity<List<FarmerDto>> getAllFarmers() {
        List<FarmerDto> farmers = farmerService.getAllFarmers();
        logger.info("Retrieved {} KharifFarmer from the database", farmers.size());
        return new ResponseEntity<>(farmers, HttpStatus.OK);
    }

    // Get KharifFarmer by ID
    @GetMapping("/get/kharif/{farmerId}")
    public ResponseEntity<FarmerDto> getFarmerById(@PathVariable Long farmerId) {
        Optional<FarmerDto> farmer = farmerService.getFarmerId(farmerId);
        if (farmer.isPresent()) {
            logger.info("Retrieved KharifFarmer with ID: {}", farmerId);
            return new ResponseEntity<>(farmer.get(), HttpStatus.OK);
        } else {
            logger.warn("KharifFarmer with ID {} not found", farmerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update KharifFarmer by ID
    @PutMapping("/update/kharif/{farmerId}")
    public ResponseEntity<FarmerDto> updateFarmer(@PathVariable Long farmerId, @RequestBody FarmerDto updatedFarmerDto) {
    	FarmerDto updatedFarmer = farmerService.updateFarmer(farmerId, updatedFarmerDto);
        if (updatedFarmer != null) {
            logger.info("Updated KharifFarmer with ID: {}", farmerId);
            return new ResponseEntity<>(updatedFarmer, HttpStatus.OK);
        } else {
            logger.warn("KharifFarmer with ID {} not found for update", farmerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    


    // Delete KharifFarmer by ID
    @DeleteMapping("/delete/kharif/{farmerId}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable Long farmerId) {
        farmerService.deleteFarmer(farmerId);
        logger.info("Deleted KharifFarmer with ID: {}", farmerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/khariffarmer")
	    public long countFarmer()
	    {
	    	return farmerService.countFarmer();
	    }


}
