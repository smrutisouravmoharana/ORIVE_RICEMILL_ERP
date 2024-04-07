package com.orive.Stock.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orive.Stock.Entity.Purchase;
import com.orive.Stock.Entity.Stock;
import com.orive.Stock.Repository.StockRepository;

@Service
public class StockService {

	private Logger logger=LoggerFactory.getLogger(StockService.class);
	
    @Autowired
	private StockRepository stockRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    
    public Optional<Stock> getStock(Long stockId) {
        Optional<Stock> stock = stockRepository.findById(stockId);

        if (stock.isPresent()) {
            // Fetch associated Purchase data from an external API (modify the URL accordingly)
            String purchaseApiUrl = "http://localhost:8089/gowdown/get/" + stockId;
            ArrayList<Purchase> purchases = restTemplate.getForObject(purchaseApiUrl, ArrayList.class);
            if (purchases != null) {
                // Set the associated purchases for the retrieved stock
                stock.get().setPurchases(purchases);
            }
        }

        return stock;
    }        
     public Stock save(Stock stock)
     {
    	 return stockRepository.save(stock);
     }
    
}
