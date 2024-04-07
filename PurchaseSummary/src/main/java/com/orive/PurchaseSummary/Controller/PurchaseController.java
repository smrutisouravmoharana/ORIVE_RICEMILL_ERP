package com.orive.PurchaseSummary.Controller;

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

import com.orive.PurchaseSummary.Dto.Purchase;
import com.orive.PurchaseSummary.Service.PurchaseService;


@RestController
@RequestMapping(value = "/gowdown")
public class PurchaseController {
	
	private Logger logger=LoggerFactory.getLogger(PurchaseController.class);

	@Autowired
	private PurchaseService gowdownService;
	
	  @PostMapping(value = "/save")
	    public ResponseEntity<Purchase> createGowdown(@RequestBody Purchase gowdown) {
	        Purchase created = gowdownService.createGowdown(gowdown);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get")
	    public ResponseEntity<List<Purchase>> getAllGowdown() {
	        List<Purchase> gowdowns = gowdownService.getAllGowdown();
	        return new ResponseEntity<>(gowdowns, HttpStatus.OK);
	    }

	    @GetMapping("/get/{purchaseId}")
	    public ResponseEntity<List<Purchase>> getGowdownByIds(@PathVariable List<Long> purchaseId) {
	        List<Purchase> gowdowns = gowdownService.getGodownById(purchaseId);
	        return new ResponseEntity<>(gowdowns, HttpStatus.OK);
	    }

	    @PutMapping("/update/{purchaseId}")
	    public ResponseEntity<Purchase> updateGowdown(
	            @PathVariable Long purchaseId, @RequestBody Purchase updatedDTO) {
	        Purchase updated = gowdownService.updateGowdown(purchaseId, updatedDTO);
	        return new ResponseEntity<>(updated, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{purchaseId}")
	    public ResponseEntity<Void> deleteGowdown(@PathVariable Long purchaseId) {
	        gowdownService.deleteGodown(purchaseId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
