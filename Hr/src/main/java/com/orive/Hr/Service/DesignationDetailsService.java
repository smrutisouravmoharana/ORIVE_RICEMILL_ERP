package com.orive.Hr.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Hr.Dto.Designation;
import com.orive.Hr.Entity.DesignationDetails;
import com.orive.Hr.Repository.DesignationDetailsRepository;

@Service
public class DesignationDetailsService {

	private Logger logger=LoggerFactory.getLogger(DesignationDetailsService.class);
	
	@Autowired
	private DesignationDetailsRepository designationDetailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create a Designation
    public Designation createDesignation(Designation designation) {
        logger.info("Creating a new designation: {}", designation);
        DesignationDetails designationDetails = modelMapper.map(designation, DesignationDetails.class);
        designationDetails = designationDetailsRepository.save(designationDetails);
        logger.info("Designation created: {}", designationDetails);
        return modelMapper.map(designationDetails, Designation.class);
    }

    // Read a Designation by ID
    public Designation getDesignationById(Long designationId) {
        logger.info("Getting designation by ID: {}", designationId);
        DesignationDetails designationDetails = designationDetailsRepository.findById(designationId)
                .orElseThrow(() -> {
                    logger.error("Designation not found for ID: {}", designationId);
                    return new RuntimeException("Designation not found");
                });
        logger.info("Retrieved designation: {}", designationDetails);
        return modelMapper.map(designationDetails, Designation.class);
    }

    // Update a Designation
    public Designation updateDesignation(Long designationId, Designation updatedDesignation) {
        logger.info("Updating designation with ID {}: {}", designationId, updatedDesignation);
        DesignationDetails designationDetails = designationDetailsRepository.findById(designationId)
                .orElseThrow(() -> {
                    logger.error("Designation not found for ID: {}", designationId);
                    return new RuntimeException("Designation not found");
                });
        modelMapper.map(updatedDesignation, designationDetails);
        designationDetails = designationDetailsRepository.save(designationDetails);
        logger.info("Updated designation: {}", designationDetails);
        return modelMapper.map(designationDetails, Designation.class);
    }

    // Delete a Designation
    public void deleteDesignation(Long designationId) {
        logger.info("Deleting designation with ID: {}", designationId);
        designationDetailsRepository.deleteById(designationId);
        logger.info("Designation deleted with ID: {}", designationId);
    }

    // Get all Designations
    public List<Designation> getAllDesignations() {
        logger.info("Getting all designations");
        List<DesignationDetails> designationDetailsList = designationDetailsRepository.findAll();
        logger.info("Retrieved {} designations", designationDetailsList.size());
        return designationDetailsList.stream()
                .map(designationDetails -> modelMapper.map(designationDetails, Designation.class))
                .collect(Collectors.toList());
    }
}
