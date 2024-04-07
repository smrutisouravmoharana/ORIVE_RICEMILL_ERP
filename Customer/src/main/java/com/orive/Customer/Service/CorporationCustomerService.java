package com.orive.Customer.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Customer.Dto.CorporationCustomerDto;
import com.orive.Customer.Entity.CorporationCustomerDetails;
import com.orive.Customer.Repository.CorporationCustomerRepository;


import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.NotFoundException;

@Service
public class CorporationCustomerService {

	private Logger logger=LoggerFactory.getLogger(CorporationCustomerService.class);

	@Autowired
	private CorporationCustomerRepository individualCustomerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//create customer 
	public CorporationCustomerDto createCorporationCustomer(CorporationCustomerDto customer) {
	    logger.info("Creating a new customer");
        CorporationCustomerDetails individualCustomerDetails = modelMapper.map(customer, CorporationCustomerDetails.class);
        CorporationCustomerDetails savedProduct = individualCustomerRepository.save(individualCustomerDetails);
        return modelMapper.map(savedProduct, CorporationCustomerDto.class);
    }
	
    //get all customer list by customerId
    public List<CorporationCustomerDto> getAllCorporationCustomer() {
	 logger.info("Fetching all customers");	 
        List<CorporationCustomerDetails> mandiDetails = individualCustomerRepository.findAll();
        return mandiDetails.stream()
                       .map(mandi -> modelMapper.map(mandi, CorporationCustomerDto.class))
                       .collect(Collectors.toList());
    }

    //get details of customer by customerId
    public List<CorporationCustomerDto> getCorporationCustomerById(List<Long> corporationCustomerId) {
	 logger.info("Fetchin  customers by IDs");
        List<CorporationCustomerDetails> mandiDetails = individualCustomerRepository.findAllById(corporationCustomerId);

        return mandiDetails.stream()
                       .map(mandi -> modelMapper.map(mandi, CorporationCustomerDto.class))
                       .collect(Collectors.toList());
    }
    
    public List<CorporationCustomerDto> getByCustomerName(String customerName) {
        logger.info("Fetching customers by business owner name: {}", customerName);
        Optional<CorporationCustomerDetails> customers = individualCustomerRepository.findByCustomerName(customerName);

        if (!customers.isEmpty()) {
            return customers.stream()
                    .map(customer -> modelMapper.map(customer, CorporationCustomerDto.class))
                    .collect(Collectors.toList());
        } else {
            logger.info("No customers found with business owner name: {}", customerName);
            throw new NotFoundException("No customers found with business owner name: " + customerName);
        }
    }

    //delete customer by customerId
    public void deleteCorporationCustomer(Long corporationCustomerId) {
	 logger.info("Deleting customer by ID: {}", corporationCustomerId);
        CorporationCustomerDetails existingMandi = individualCustomerRepository.findById(corporationCustomerId)
                                                  .orElseThrow(() -> new EntityNotFoundException("customerId not found"));

        individualCustomerRepository.delete(existingMandi);
    }	
    
    //update customer details by customerId
    public CorporationCustomerDto updateCorporationCustomer(Long corporationCustomerId, CorporationCustomerDto updatedMandiDTO) {
	 logger.info("Updating supplier with ID: {}", corporationCustomerId);
        CorporationCustomerDetails mandiDetails = individualCustomerRepository.findById(corporationCustomerId)
                                                  .orElseThrow(() -> new EntityNotFoundException("customerId not found"));

        modelMapper.map(updatedMandiDTO, mandiDetails);

        CorporationCustomerDetails updatedMandi = individualCustomerRepository.save(mandiDetails);
        return modelMapper.map(updatedMandi, CorporationCustomerDto.class);
    }
    
    //update customer by name
  //update list by name
    public CorporationCustomerDto updateCorporationCustomer(String customerName, CorporationCustomerDto updatedMandiDTO) {
   	 logger.info("Updating supplier with name: {}", customerName);
           CorporationCustomerDetails mandiDetails = individualCustomerRepository.findByCustomerName(customerName)
                                                     .orElseThrow(() -> new EntityNotFoundException("customerName not found"));

           modelMapper.map(updatedMandiDTO, mandiDetails);

           CorporationCustomerDetails updatedMandi = individualCustomerRepository.save(mandiDetails);
           return modelMapper.map(updatedMandi, CorporationCustomerDto.class);
       }
    
    //count the total customerlist
    public long countCustomer()
	 {
		 return individualCustomerRepository.count();
	 }
}
