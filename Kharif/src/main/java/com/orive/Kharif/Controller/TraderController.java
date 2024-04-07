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

import com.orive.Kharif.Dto.TraderDto;
import com.orive.Kharif.Service.TraderService;


@RestController
@RequestMapping(value = "/khariftrader")
@CrossOrigin("*")
public class TraderController {
	
   private static final Logger logger=LoggerFactory.getLogger(TraderController.class); 
	
	@Autowired
	private TraderService traderService  ;
	
	
	//API FOR kharifTrader
	// Create a new kharifTrader
    @PostMapping("/create/khariftrader")
    public ResponseEntity<TraderDto> createTrader(@RequestBody TraderDto traderDto) {
    	TraderDto createdTrader = traderService.createTrader(traderDto);
        logger.info("Created kharifTrader with name: {}", createdTrader.getTraderId());
        return new ResponseEntity<>(createdTrader, HttpStatus.CREATED);
    }

    // Get all kharifTrader 
    @GetMapping("/get/khariftrader")
    public ResponseEntity<List<TraderDto>> getAllTraders() {
        List<TraderDto> traders = traderService.getAllTraders();
        logger.info("Retrieved {} kharifTrader from the database", traders.size());
        return new ResponseEntity<>(traders, HttpStatus.OK);
    }

    // Get kharifTrader by ID
    @GetMapping("/get/kharif/{traderId}")
    public ResponseEntity<TraderDto> getTraderById(@PathVariable Long traderId) {
        Optional<TraderDto> trader = traderService.getTraderId(traderId);
        if (trader.isPresent()) {
            logger.info("Retrieved kharifTrader with ID: {}", traderId);
            return new ResponseEntity<>(trader.get(), HttpStatus.OK);
        } else {
            logger.warn("kharifTrader with ID {} not found", traderId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update kharifTrader by ID
    @PutMapping("/update/kharif/{traderId}")
    public ResponseEntity<TraderDto> updateTrader(@PathVariable Long traderId, @RequestBody TraderDto updatedTraderDto) {
    	TraderDto updatedTrader = traderService.updateTrader(traderId, updatedTraderDto);
        if (updatedTrader != null) {
            logger.info("Updated kharifTrader with ID: {}", traderId);
            return new ResponseEntity<>(updatedTrader, HttpStatus.OK);
        } else {
            logger.warn("kharifTrader with ID {} not found for update", traderId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    


    // Delete kharifTrader by ID
    @DeleteMapping("/delete/kharif/{traderId}")
    public ResponseEntity<Void> deleteTrader(@PathVariable Long traderId) {
        traderService.deleteTrader(traderId);
        logger.info("Deleted kharifTrader with ID: {}", traderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    
	    @GetMapping("/count/khariftrader")
	    public long countTrader()
	    {
	    	return traderService.countTrader();
	    }


}
