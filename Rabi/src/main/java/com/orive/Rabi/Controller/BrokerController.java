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

import com.orive.Rabi.Dto.BrokerDto;
import com.orive.Rabi.Service.BrokerService;


@RestController
@RequestMapping(value = "rabibroker")
@CrossOrigin("*")
public class BrokerController {
	
private static final Logger logger=LoggerFactory.getLogger(BrokerController.class); 
	
	@Autowired
	private BrokerService  brokerService;
	
	
	//API FOR RabiBroker
	// Create a new RabiBroker
    @PostMapping("/create/rabibroker")
    public ResponseEntity<BrokerDto> createBroker(@RequestBody BrokerDto brokerDto) {
    	BrokerDto createdBroker = brokerService.createBroker(brokerDto);
        logger.info("Created RabiBroker with name: {}", createdBroker.getBrokerId());
        return new ResponseEntity<>(createdBroker, HttpStatus.CREATED);
    }

    // Get all RabiBroker
    
    @GetMapping("/get/rabibroker")
    public ResponseEntity<List<BrokerDto>> getAllBrokers() {
        List<BrokerDto> brokers = brokerService.getAllBrokers();
        logger.info("Retrieved {} RabiBroker from the database", brokers.size());
        return new ResponseEntity<>(brokers, HttpStatus.OK);
    }

    // Get RabiBroker by ID
    @GetMapping("/get/rabi/{brokerId}")
    public ResponseEntity<BrokerDto> getBrokerById(@PathVariable Long brokerId) {
        Optional<BrokerDto> broker = brokerService.getBrokerById(brokerId);
        if (broker.isPresent()) {
            logger.info("Retrieved RabiBroker with ID: {}", brokerId);
            return new ResponseEntity<>(broker.get(), HttpStatus.OK);
        } else {
            logger.warn("RabiBroker with ID {} not found", brokerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update RabiBroker by ID
    @PutMapping("/update/rabi/{brokerId}")
    public ResponseEntity<BrokerDto> updateBroker(@PathVariable Long brokerId, @RequestBody BrokerDto updatedBrokerDto) {
    	BrokerDto updatedBroker = brokerService.updateBroker(brokerId, updatedBrokerDto);
        if (updatedBroker != null) {
            logger.info("Updated RabiBroker with ID: {}", brokerId);
            return new ResponseEntity<>(updatedBroker, HttpStatus.OK);
        } else {
            logger.warn("RabiBroker with ID {} not found for update", brokerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    


    // Delete RabiBroker by ID
    @DeleteMapping("/delete/rabi/{brokerId}")
    public ResponseEntity<Void> deleteBroker(@PathVariable Long brokerId) {
        brokerService.deleteBroker(brokerId);
        logger.info("Deleted RabiBroker with ID: {}", brokerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/rabibroker")
	    public long countBroker()
	    {
	    	return brokerService.countBroker();
	    }

}
