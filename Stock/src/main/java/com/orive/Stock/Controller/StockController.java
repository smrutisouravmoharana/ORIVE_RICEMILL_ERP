package com.orive.Stock.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Stock.Entity.Stock;
import com.orive.Stock.Service.StockService;

import jakarta.ws.rs.GET;

@RestController
@RequestMapping("/stock")
public class StockController {

	private Logger logger = LoggerFactory.getLogger(StockController.class);

    @Autowired
    private StockService stockService;
    
//    @GetMapping("/get")
//    public ResponseEntity<List<Stock>> getAllStock() {
//        logger.info("Fetching all Stocks");
//        List<Stock> stocks = stockService.getAll();
//        return new ResponseEntity<>(stocks, HttpStatus.OK);
//    }
    @GetMapping(value = "/get/{stockId}")
    public Optional<Stock> get(@PathVariable("stockId") Long stockId)
    {
    	return stockService.getStock(stockId);
    }
    
    @PostMapping(value = "/create")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        Stock createdStock = stockService.save(stock);
        return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
    }
}
