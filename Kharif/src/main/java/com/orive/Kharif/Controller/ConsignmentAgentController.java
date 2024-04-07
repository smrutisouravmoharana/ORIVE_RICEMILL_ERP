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

import com.orive.Kharif.Dto.ConsignmentAgentDto;
import com.orive.Kharif.Service.ConsignmentAgentService;



@RestController
@RequestMapping(value = "/kharifconsignmentagent")
@CrossOrigin("*")
public class ConsignmentAgentController {
	
private static final Logger logger=LoggerFactory.getLogger(ConsignmentAgentController.class); 
	
	@Autowired
	private ConsignmentAgentService consignmentAgentService  ;
	
	
	//API FOR KharifConsignmentAgent
	// Create a new KharifConsignmentAgent
    @PostMapping("/create/kharifconsignmentagent")
    public ResponseEntity<ConsignmentAgentDto> createConsignmentAgent(@RequestBody ConsignmentAgentDto consignmentAgentDto) {
    	ConsignmentAgentDto createdConsignmentAgent = consignmentAgentService.createConsignmentAgent(consignmentAgentDto);
        logger.info("Created KharifConsignmentAgent with name: {}", createdConsignmentAgent.getConsignmentAgentId());
        return new ResponseEntity<>(createdConsignmentAgent, HttpStatus.CREATED);
    }

    // Get all KharifConsignmentAgent
    
    @GetMapping("/get/kharifconsignmentagent")
    public ResponseEntity<List<ConsignmentAgentDto>> getAllConsignmentAgents() {
        List<ConsignmentAgentDto> consignmentAgent = consignmentAgentService.getAllConsignmentAgents();
        logger.info("Retrieved {} KharifConsignmentAgent from the database", consignmentAgent.size());
        return new ResponseEntity<>(consignmentAgent, HttpStatus.OK);
    }

    // Get KharifConsignmentAgent by ID
    @GetMapping("/get/rabi/{consignmentagentId}")
    public ResponseEntity<ConsignmentAgentDto> getConsignmentAgentById(@PathVariable Long consignmentAgentId) {
        Optional<ConsignmentAgentDto> consignmentAgent = consignmentAgentService.getConsignmentAgentId(consignmentAgentId);
        if (consignmentAgent.isPresent()) {
            logger.info("Retrieved KharifConsignmentAgent with ID: {}", consignmentAgentId);
            return new ResponseEntity<>(consignmentAgent.get(), HttpStatus.OK);
        } else {
            logger.warn("KharifConsignmentAgent with ID {} not found", consignmentAgentId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update KharifConsignmentAgent by ID
    @PutMapping("/update/rabi/{consignmentagentId}")
    public ResponseEntity<ConsignmentAgentDto> updateConsignmentAgent(@PathVariable Long consignmentAgentId, @RequestBody ConsignmentAgentDto updatedConsignmentAgentDto) {
    	ConsignmentAgentDto updatedConsignmentAgent = consignmentAgentService.updateConsignmentAgent(consignmentAgentId, updatedConsignmentAgentDto);
        if (updatedConsignmentAgent != null) {
            logger.info("Updated KharifConsignmentAgent with ID: {}", consignmentAgentId);
            return new ResponseEntity<>(updatedConsignmentAgent, HttpStatus.OK);
        } else {
            logger.warn("KharifConsignmentAgent with ID {} not found for update", consignmentAgentId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    


    // Delete KharifConsignmentAgent by ID
    @DeleteMapping("/delete/rabi/{consignmentagentId}")
    public ResponseEntity<Void> deleteConsignmentAgent(@PathVariable Long consignmentAgentId) {
        consignmentAgentService.deleteConsignmentAgent(consignmentAgentId);
        logger.info("Deleted KharifConsignmentAgent with ID: {}", consignmentAgentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/kharifconsignmentagent")
	    public long countConsignmentAgent()
	    {
	    	return consignmentAgentService.countConsignmentAgent();
	    }

}
