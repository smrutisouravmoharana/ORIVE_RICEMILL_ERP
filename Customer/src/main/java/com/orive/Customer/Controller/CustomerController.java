package com.orive.Customer.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Customer.Dto.CorporationCustomerDto;
import com.orive.Customer.Dto.IndividualCustomerDto;
import com.orive.Customer.Service.CorporationCustomerService;
import com.orive.Customer.Service.IndividualCustomerService;

import jakarta.ws.rs.NotFoundException;


@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {
	
	private Logger logger=LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private IndividualCustomerService individualCustomerService;
	
	@Autowired
	private CorporationCustomerService corporationCustomerService;
	
	 @PostMapping(value = "/save/customer")
	    public ResponseEntity<IndividualCustomerDto> createSupplier(@RequestBody IndividualCustomerDto mandi) {
	    	logger.info("Creating a new Customer");
	        IndividualCustomerDto created = individualCustomerService.createCustomer(mandi);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get/customer")
	    public ResponseEntity<List<IndividualCustomerDto>> getAllProducts() {
	    	 logger.info("Fetching all Customers");
	        List<IndividualCustomerDto> products = individualCustomerService.getAllCustomer();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @GetMapping("/get/{individualCustomerId}")
	    public ResponseEntity<List<IndividualCustomerDto>> getProductsByIds(@PathVariable List<Long> individualCustomerId) {
	    	logger.info("Fetching customers by IDs");
	        List<IndividualCustomerDto> products = individualCustomerService.getCustomerById(individualCustomerId);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
	    
	    @GetMapping("/customerName")
	    public ResponseEntity<List<IndividualCustomerDto>> getCustomersByBusinessOwnerName(
	            @RequestParam("customerName") String customerName) {
	        List<IndividualCustomerDto> customers = individualCustomerService.getByCustomerName(customerName);
	        if (!customers.isEmpty()) {
	            return new ResponseEntity<>(customers, HttpStatus.OK);
	        } else {
	            throw new NotFoundException("No customers found with business owner name: " + customerName);
	        }
	    }

	    @PutMapping("/update/{individualCustomerId}")
	    public ResponseEntity<IndividualCustomerDto> updateProduct(
	            @PathVariable Long individualCustomerId, @RequestBody IndividualCustomerDto updatedMandiDTO) {
	    	logger.info("Updating customer with ID: {}", individualCustomerId);
	        IndividualCustomerDto updatedMandi = individualCustomerService.updateCustomer(individualCustomerId, updatedMandiDTO);
	        return new ResponseEntity<>(updatedMandi, HttpStatus.OK);
	    }
	    
	    @PutMapping("/update/{customerName}")
	    public ResponseEntity<IndividualCustomerDto> updateProduct(
	            @PathVariable String customerName, @RequestBody IndividualCustomerDto updatedMandiDTO) {
	    	logger.info("Updating customer with name: {}", customerName);
	        IndividualCustomerDto updatedMandi = individualCustomerService.updateCustomer(customerName, updatedMandiDTO);
	        return new ResponseEntity<>(updatedMandi, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{individualCustomerId}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long individualCustomerId) {
	    	logger.info("Deleting customer with ID: {}", individualCustomerId);
	        individualCustomerService.deleteCustomer(individualCustomerId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    @GetMapping("/count/customer")
	    public long countCustomer()
	    {
	    	return individualCustomerService.countCustomer();
	    }
	    
	    
	    //----------------------------------------------------------------------------------------------------------------------
	    
	    @PostMapping(value = "/save/corporatecustomer")
	    public ResponseEntity<CorporationCustomerDto> createCorporateSupplier(@RequestBody CorporationCustomerDto mandi) {
	    	logger.info("Creating a new Customer");
	        CorporationCustomerDto created = corporationCustomerService.createCorporationCustomer(mandi);
	        return new ResponseEntity<>(created, HttpStatus.CREATED);
	    }

	    @GetMapping(value = "/get/corporatecustomer")
	    public ResponseEntity<List<CorporationCustomerDto>> getAllCorporateProducts() {
	    	 logger.info("Fetching all Customers");
	        List<CorporationCustomerDto> products = corporationCustomerService.getAllCorporationCustomer();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }

	    @GetMapping("/get/{corporationCustomerId}")
	    public ResponseEntity<List<CorporationCustomerDto>> getCorporateProductsByIds(@PathVariable List<Long> corporationCustomerId) {
	    	logger.info("Fetching customers by IDs");
	        List<CorporationCustomerDto> products = corporationCustomerService.getCorporationCustomerById(corporationCustomerId);
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    }
	    @GetMapping("/corporate/customerName")
	    public ResponseEntity<List<CorporationCustomerDto>> getCorporateCustomersByBusinessOwnerName(
	            @RequestParam("customerName") String customerName) {
	        List<CorporationCustomerDto> customers = corporationCustomerService.getByCustomerName(customerName);
	        if (!customers.isEmpty()) {
	            return new ResponseEntity<>(customers, HttpStatus.OK);
	        } else {
	            throw new NotFoundException("No customers found with business owner name: " + customerName);
	        }
	    }

	    @PutMapping("/update/{corporationCustomerId}")
	    public ResponseEntity<CorporationCustomerDto> updateCorporateProduct(
	            @PathVariable Long corporationCustomerId, @RequestBody CorporationCustomerDto updatedMandiDTO) {
	    	logger.info("Updating customer with ID: {}", corporationCustomerId);
	        CorporationCustomerDto updatedMandi = corporationCustomerService.updateCorporationCustomer(corporationCustomerId, updatedMandiDTO);
	        return new ResponseEntity<>(updatedMandi, HttpStatus.OK);
	    }
	    
	    @PutMapping("/corporationupdate/{customerName}")
	    public ResponseEntity<CorporationCustomerDto> updateCorporateProduct(
	            @PathVariable String customerName, @RequestBody CorporationCustomerDto updatedMandiDTO) {
	    	logger.info("Updating customer with name: {}", customerName);
	        CorporationCustomerDto updatedMandi = corporationCustomerService.updateCorporationCustomer(customerName, updatedMandiDTO);
	        return new ResponseEntity<>(updatedMandi, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{corporationCustomerId}")
	    public ResponseEntity<Void> deleteCorporateProduct(@PathVariable Long corporationCustomerId) {
	    	logger.info("Deleting customer with ID: {}", corporationCustomerId);
	    	corporationCustomerService.deleteCorporationCustomer(corporationCustomerId);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    
	    @GetMapping("/count/corporationcustomer")
	    public long countCorporateCustomer()
	    {
	    	return individualCustomerService.countCustomer();
	    }
}
