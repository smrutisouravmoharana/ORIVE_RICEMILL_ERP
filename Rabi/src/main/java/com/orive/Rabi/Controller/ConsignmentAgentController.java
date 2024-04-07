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

import com.orive.Rabi.Dto.ConsignmentAgentDto;
import com.orive.Rabi.Service.ConsignmentAgentService;



@RestController
@RequestMapping(value = "/rabiconsignmentagent")
@CrossOrigin("*")
public class ConsignmentAgentController {
	
private static final Logger logger=LoggerFactory.getLogger(ConsignmentAgentController.class); 
	
	@Autowired
	private ConsignmentAgentService consignmentAgentService  ;
	
	
	//API FOR RabiConsignmentAgent
	// Create a new RabiConsignmentAgent
    @PostMapping("/create/rabiconsignmentagent")
    public ResponseEntity<ConsignmentAgentDto> createConsignmentAgent(@RequestBody ConsignmentAgentDto consignmentAgentDto) {
    	ConsignmentAgentDto createdConsignmentAgent = consignmentAgentService.createConsignmentAgent(consignmentAgentDto);
        logger.info("Created RabiConsignmentAgent with name: {}", createdConsignmentAgent.getConsignmentAgentId());
        return new ResponseEntity<>(createdConsignmentAgent, HttpStatus.CREATED);
    }

    // Get all RabiConsignmentAgent
    
    @GetMapping("/get/rabiconsignmentagent")
    public ResponseEntity<List<ConsignmentAgentDto>> getAllConsignmentAgents() {
        List<ConsignmentAgentDto> consignmentAgent = consignmentAgentService.getAllConsignmentAgents();
        logger.info("Retrieved {} RabiConsignmentAgent from the database", consignmentAgent.size());
        return new ResponseEntity<>(consignmentAgent, HttpStatus.OK);
    }

    // Get RabiConsignmentAgent by ID
    @GetMapping("/get/rabi/{consignmentagentId}")
    public ResponseEntity<ConsignmentAgentDto> getConsignmentAgentById(@PathVariable Long consignmentAgentId) {
        Optional<ConsignmentAgentDto> consignmentAgent = consignmentAgentService.getConsignmentAgentId(consignmentAgentId);
        if (consignmentAgent.isPresent()) {
            logger.info("Retrieved RabiConsignmentAgent with ID: {}", consignmentAgentId);
            return new ResponseEntity<>(consignmentAgent.get(), HttpStatus.OK);
        } else {
            logger.warn("RabiConsignmentAgent with ID {} not found", consignmentAgentId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update RabiConsignmentAgent by ID
    @PutMapping("/update/rabi/{consignmentagentId}")
    public ResponseEntity<ConsignmentAgentDto> updateConsignmentAgent(@PathVariable Long consignmentAgentId, @RequestBody ConsignmentAgentDto updatedConsignmentAgentDto) {
    	ConsignmentAgentDto updatedConsignmentAgent = consignmentAgentService.updateConsignmentAgent(consignmentAgentId, updatedConsignmentAgentDto);
        if (updatedConsignmentAgent != null) {
            logger.info("Updated RabiConsignmentAgent with ID: {}", consignmentAgentId);
            return new ResponseEntity<>(updatedConsignmentAgent, HttpStatus.OK);
        } else {
            logger.warn("RabiConsignmentAgent with ID {} not found for update", consignmentAgentId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    


    // Delete RabiConsignmentAgent by ID
    @DeleteMapping("/delete/rabi/{consignmentagentId}")
    public ResponseEntity<Void> deleteConsignmentAgent(@PathVariable Long consignmentAgentId) {
        consignmentAgentService.deleteConsignmentAgent(consignmentAgentId);
        logger.info("Deleted RabiConsignmentAgent with ID: {}", consignmentAgentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/rabiconsignmentagent")
	    public long countConsignmentAgent()
	    {
	    	return consignmentAgentService.countConsignmentAgent();
	    }

}
