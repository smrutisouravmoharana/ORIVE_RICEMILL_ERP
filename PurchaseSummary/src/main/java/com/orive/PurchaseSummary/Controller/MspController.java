package com.orive.PurchaseSummary.Controller;

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

import com.orive.PurchaseSummary.Dto.MspDto;
import com.orive.PurchaseSummary.Service.MspService;


@RestController
@RequestMapping(value = "/msp")
@CrossOrigin("*")
public class MspController {
	
	private Logger logger=LoggerFactory.getLogger(MspController.class);
	
	@Autowired
	private MspService mspService;
	
	
	 //API FOR Msp
	 // Create a new Msp
	    @PostMapping("/create/msp")
	    public ResponseEntity<MspDto> createMsp(@RequestBody MspDto mspDto) {
	    	MspDto createdMsp =mspService.createMsp(mspDto);
	        logger.info("Created Msp with name: {}", createdMsp.getMspId());
	        return new ResponseEntity<>(createdMsp, HttpStatus.CREATED);
	    }

	    // Get all Msp    
	    @GetMapping("/get/msp")
	    public ResponseEntity<List<MspDto>> getAllMsp() {
	        List<MspDto> msp = mspService.getAllMsp();
	        logger.info("Retrieved {} Msp from the database", msp.size());
	        return new ResponseEntity<>(msp, HttpStatus.OK);
	    }  
	   
	    // Get Msp by ID
	    @GetMapping("/get/{mspId}")
	    public ResponseEntity<MspDto> getMspById(@PathVariable Long mspId) {
	        Optional<MspDto> msp = mspService.getMspById(mspId);
	        if (msp.isPresent()) {
	            logger.info("Retrieved Msp with ID: {}", mspId);
	            return new ResponseEntity<>(msp.get(), HttpStatus.OK);
	        } else {
	            logger.warn("Msp with ID {} not found", mspId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Update Msp by ID
	    @PutMapping("/update/{mspId}")
	    public ResponseEntity<MspDto> updateMsp(@PathVariable Long mspId, @RequestBody MspDto updatedMspDTO) {
	    	MspDto updatedMsp = mspService.updateMsp(mspId, updatedMspDTO);
	        if (updatedMsp != null) {
	            logger.info("Updated Msp with ID: {}", mspId);
	            return new ResponseEntity<>(updatedMsp, HttpStatus.OK);
	        } else {
	            logger.warn("Msp with ID {} not found for update", mspId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    // Delete Msp by ID
	    @DeleteMapping("/delete/{mspId}")
	    public ResponseEntity<Void> deleteMsp(@PathVariable Long mspId) {
	        mspService.deleteMsp(mspId);
	        logger.info("Deleted Msp with ID: {}", mspId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    //Count Corporate Msp 
	    @GetMapping("/count/msp")
	    public long countMsp()
	    {
	    	return mspService.countMsp();
	    }
	    

}
