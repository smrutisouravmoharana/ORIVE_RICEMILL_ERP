package com.orive.Hr.Controller;

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

import com.orive.Hr.Dto.Designation;
import com.orive.Hr.Service.DesignationDetailsService;

@RestController
@RequestMapping(value = "/designation")
public class DesignationDetailsController {

	private Logger logger=LoggerFactory.getLogger(DesignationDetailsController.class);
	
	@Autowired
	private DesignationDetailsService designationService;
	
	@PostMapping(value = "/create")
    public ResponseEntity<Designation> createDesignation(@RequestBody Designation designation) {
        logger.info("Creating a new designation: {}", designation);
        Designation createdDesignation = designationService.createDesignation(designation);
        logger.info("Created designation: {}", createdDesignation);
        return new ResponseEntity<>(createdDesignation, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getbyid/{designationId}")
    public ResponseEntity<Designation> getDesignationById(@PathVariable Long designationId) {
        logger.info("Getting designation by ID: {}", designationId);
        Designation designation = designationService.getDesignationById(designationId);
        logger.info("Retrieved designation: {}", designation);
        return new ResponseEntity<>(designation, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{designationId}")
    public ResponseEntity<Designation> updateDesignation(@PathVariable Long designationId, @RequestBody Designation updatedDesignation) {
        logger.info("Updating designation with ID {}: {}", designationId, updatedDesignation);
        Designation designation = designationService.updateDesignation(designationId, updatedDesignation);
        logger.info("Updated designation: {}", designation);
        return new ResponseEntity<>(designation, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{designationId}")
    public ResponseEntity<Void> deleteDesignation(@PathVariable Long designationId) {
        logger.info("Deleting designation with ID: {}", designationId);
        designationService.deleteDesignation(designationId);
        logger.info("Designation deleted with ID: {}", designationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<Designation>> getAllDesignations() {
        logger.info("Getting all designations");
        List<Designation> designations = designationService.getAllDesignations();
        logger.info("Retrieved {} designations", designations.size());
        return new ResponseEntity<>(designations, HttpStatus.OK);
    }
}
