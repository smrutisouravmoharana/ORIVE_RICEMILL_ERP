package com.orive.Transportation.Controller;

import java.util.List;

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


import com.orive.Transportation.Dto.Transportation;
import com.orive.Transportation.Service.TransportationService;

@RestController
@RequestMapping(value = "/transportation")
public class TransportationController {
	
	private Logger logger=LoggerFactory.getLogger(TransportationController.class);

	@Autowired
	private TransportationService transportationService;
	
	 @PostMapping(value = "/save")
	    public ResponseEntity<Transportation> createTransportation(@RequestBody Transportation transportation) {
	        Transportation createdTransportation = transportationService.createTransportationDetails(transportation);
	        return new ResponseEntity<>(createdTransportation, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get")
	    public ResponseEntity<List<Transportation>> getAllTransportation() {
	        List<Transportation> transportations = transportationService.getAllTransportation();
	        return new ResponseEntity<>(transportations, HttpStatus.OK);
	    }

	    @GetMapping(value = "/get/{transportationId}")
	    public ResponseEntity<List<Transportation>> getTransportationByIds(@PathVariable List<Long> transportationId) {
	        List<Transportation> transportations = transportationService.getTransportationById(transportationId);
	        return new ResponseEntity<>(transportations, HttpStatus.OK);
	    }

	    @PutMapping(value = "/update/{transportationId}")
	    public ResponseEntity<Transportation> updateTransportation(
	            @PathVariable Long transportationId, @RequestBody Transportation updatedTransportation) {
	        Transportation updated = transportationService.updateTransportation(transportationId, updatedTransportation);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @DeleteMapping(value = "/delete/{transportationId}")
	    public ResponseEntity<Void> deleteTransportation(@PathVariable Long transportationId) {
	        transportationService.deleteTransportation(transportationId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    @GetMapping(value = "/count")
	    public long countTransporationDetails()
	     {
	    	return transportationService.countTransporationDetails();
	     }
}
