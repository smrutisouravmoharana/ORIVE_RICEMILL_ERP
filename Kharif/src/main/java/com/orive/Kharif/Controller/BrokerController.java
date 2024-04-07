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

import com.orive.Kharif.Dto.BrokerDto;
import com.orive.Kharif.Service.BrokerService;


@RestController
@RequestMapping(value = "kharifbroker")
@CrossOrigin("*")
public class BrokerController {
	
	private static final Logger logger=LoggerFactory.getLogger(BrokerController.class); 
	
	@Autowired
	private BrokerService  brokerService;
	
	
	//API FOR KharifBroker
	// Create a new KharifBroker
    @PostMapping("/create/kharifbroker")
    public ResponseEntity<BrokerDto> createBroker(@RequestBody BrokerDto brokerDto) {
    	BrokerDto createdBroker = brokerService.createBroker(brokerDto);
        logger.info("Created KharifBroker with name: {}", createdBroker.getBrokerId());
        return new ResponseEntity<>(createdBroker, HttpStatus.CREATED);
    }

    // Get all KharifBroker
    
    @GetMapping("/get/kharifbroker")
    public ResponseEntity<List<BrokerDto>> getAllBrokers() {
        List<BrokerDto> brokers = brokerService.getAllBrokers();
        logger.info("Retrieved {} KharifBroker from the database", brokers.size());
        return new ResponseEntity<>(brokers, HttpStatus.OK);
    }

    // Get KharifBroker by ID
    @GetMapping("/get/kharif/{brokerId}")
    public ResponseEntity<BrokerDto> getBrokerById(@PathVariable Long brokerId) {
        Optional<BrokerDto> broker = brokerService.getBrokerById(brokerId);
        if (broker.isPresent()) {
            logger.info("Retrieved KharifBroker with ID: {}", brokerId);
            return new ResponseEntity<>(broker.get(), HttpStatus.OK);
        } else {
            logger.warn("KharifBroker with ID {} not found", brokerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update KharifBroker by ID
    @PutMapping("/update/kharif/{brokerId}")
    public ResponseEntity<BrokerDto> updateBroker(@PathVariable Long brokerId, @RequestBody BrokerDto updatedBrokerDto) {
    	BrokerDto updatedBroker = brokerService.updateBroker(brokerId, updatedBrokerDto);
        if (updatedBroker != null) {
            logger.info("Updated KharifBroker with ID: {}", brokerId);
            return new ResponseEntity<>(updatedBroker, HttpStatus.OK);
        } else {
            logger.warn("KharifBroker with ID {} not found for update", brokerId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    


    // Delete KharifBroker by ID
    @DeleteMapping("/delete/kharif/{brokerId}")
    public ResponseEntity<Void> deleteBroker(@PathVariable Long brokerId) {
        brokerService.deleteBroker(brokerId);
        logger.info("Deleted KharifBroker with ID: {}", brokerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/kharifbroker")
	    public long countBroker()
	    {
	    	return brokerService.countBroker();
	    }

}
