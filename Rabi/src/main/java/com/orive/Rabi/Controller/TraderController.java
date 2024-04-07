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

import com.orive.Rabi.Dto.TraderDto;
import com.orive.Rabi.Service.TraderService;



@RestController
@RequestMapping(value = "/rabitrader")
@CrossOrigin("*")
public class TraderController {
	
	 private static final Logger logger=LoggerFactory.getLogger(TraderController.class); 
		
		@Autowired
		private TraderService traderService  ;
		
		
		//API FOR RabiTrader
		// Create a new RabiTrader
	    @PostMapping("/create/rabitrader")
	    public ResponseEntity<TraderDto> createTrader(@RequestBody TraderDto traderDto) {
	    	TraderDto createdTrader = traderService.createTrader(traderDto);
	        logger.info("Created RabiTrader with name: {}", createdTrader.getTraderId());
	        return new ResponseEntity<>(createdTrader, HttpStatus.CREATED);
	    }

	    // Get all RabiTrader 
	    @GetMapping("/get/rabitrader")
	    public ResponseEntity<List<TraderDto>> getAllTraders() {
	        List<TraderDto> traders = traderService.getAllTraders();
	        logger.info("Retrieved {} RabiTrader from the database", traders.size());
	        return new ResponseEntity<>(traders, HttpStatus.OK);
	    }

	    // Get RabiTrader by ID
	    @GetMapping("/get/rabi/{traderId}")
	    public ResponseEntity<TraderDto> getTraderById(@PathVariable Long traderId) {
	        Optional<TraderDto> trader = traderService.getTraderId(traderId);
	        if (trader.isPresent()) {
	            logger.info("Retrieved RabiTrader with ID: {}", traderId);
	            return new ResponseEntity<>(trader.get(), HttpStatus.OK);
	        } else {
	            logger.warn("RabiTrader with ID {} not found", traderId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // Update RabiTrader by ID
	    @PutMapping("/update/rabi/{traderId}")
	    public ResponseEntity<TraderDto> updateTrader(@PathVariable Long traderId, @RequestBody TraderDto updatedTraderDto) {
	    	TraderDto updatedTrader = traderService.updateTrader(traderId, updatedTraderDto);
	        if (updatedTrader != null) {
	            logger.info("Updated RabiTrader with ID: {}", traderId);
	            return new ResponseEntity<>(updatedTrader, HttpStatus.OK);
	        } else {
	            logger.warn("RabiTrader with ID {} not found for update", traderId);
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    // Delete RabiTrader by ID
	    @DeleteMapping("/delete/rabi/{traderId}")
	    public ResponseEntity<Void> deleteTrader(@PathVariable Long traderId) {
	        traderService.deleteTrader(traderId);
	        logger.info("Deleted RabiTrader with ID: {}", traderId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
		    
		    @GetMapping("/count/rabitrader")
		    public long countTrader()
		    {
		    	return traderService.countTrader();
		    }



}
