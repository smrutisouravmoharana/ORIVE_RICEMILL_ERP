package com.orive.Customer.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Customer.Dto.IndividualCustomerDto;
import com.orive.Customer.Entity.IndividualCustomerDetails;
import com.orive.Customer.Repository.IndividualCustomerRepository;


import jakarta.persistence.EntityNotFoundException;
import jakarta.ws.rs.NotFoundException;


@Service
public class IndividualCustomerService {
	
	private Logger logger=LoggerFactory.getLogger(IndividualCustomerService.class);

	@Autowired
	private IndividualCustomerRepository individualCustomerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//create customer 
	public IndividualCustomerDto createCustomer(IndividualCustomerDto customer) {
	    logger.info("Creating a new customer");
        IndividualCustomerDetails individualCustomerDetails = modelMapper.map(customer, IndividualCustomerDetails.class);
        IndividualCustomerDetails savedProduct = individualCustomerRepository.save(individualCustomerDetails);
        return modelMapper.map(savedProduct, IndividualCustomerDto.class);
    }
	
    //get all customer list by customerId
    public List<IndividualCustomerDto> getAllCustomer() {
	 logger.info("Fetching all customers");	 
        List<IndividualCustomerDetails> mandiDetails = individualCustomerRepository.findAll();
        return mandiDetails.stream()
                       .map(mandi -> modelMapper.map(mandi, IndividualCustomerDto.class))
                       .collect(Collectors.toList());
    }

    //get details of customer by customerId
    public List<IndividualCustomerDto> getCustomerById(List<Long> individualCustomerId) {
	 logger.info("Fetchin  customers by IDs");
        List<IndividualCustomerDetails> mandiDetails = individualCustomerRepository.findAllById(individualCustomerId);

        return mandiDetails.stream()
                       .map(mandi -> modelMapper.map(mandi, IndividualCustomerDto.class))
                       .collect(Collectors.toList());
    }
    
    public List<IndividualCustomerDto> getByCustomerName(String customerName) {
        logger.info("Fetching customers by business owner name: {}", customerName);
        Optional<IndividualCustomerDetails> customers = individualCustomerRepository.findByCustomerName(customerName);

        if (!customers.isEmpty()) {
            return customers.stream()
                    .map(customer -> modelMapper.map(customer, IndividualCustomerDto.class))
                    .collect(Collectors.toList());
        } else {
            logger.info("No customers found with business owner name: {}", customerName);
            throw new NotFoundException("No customers found with business owner name: " + customerName);
        }
    }

    //delete customer by customerId
    public void deleteCustomer(Long individualCustomerId) {
	 logger.info("Deleting customer by ID: {}", individualCustomerId);
        IndividualCustomerDetails existingMandi = individualCustomerRepository.findById(individualCustomerId)
                                                  .orElseThrow(() -> new EntityNotFoundException("customerId not found"));

        individualCustomerRepository.delete(existingMandi);
    }	
    
    //update customer details by customerId
    public IndividualCustomerDto updateCustomer(Long individualCustomerId, IndividualCustomerDto updatedMandiDTO) {
	 logger.info("Updating customer with ID: {}", individualCustomerId);
        IndividualCustomerDetails mandiDetails = individualCustomerRepository.findById(individualCustomerId)
                                                  .orElseThrow(() -> new EntityNotFoundException("customerId not found"));

        modelMapper.map(updatedMandiDTO, mandiDetails);

        IndividualCustomerDetails updatedMandi = individualCustomerRepository.save(mandiDetails);
        return modelMapper.map(updatedMandi, IndividualCustomerDto.class);
    }
    
    //update customer by name
  //update list by name
    public IndividualCustomerDto updateCustomer(String customerName, IndividualCustomerDto updatedMandiDTO) {
   	 logger.info("Updating customer with name: {}", customerName);
           IndividualCustomerDetails mandiDetails = individualCustomerRepository.findByCustomerName(customerName)
                                                     .orElseThrow(() -> new EntityNotFoundException("customerName not found"));

           modelMapper.map(updatedMandiDTO, mandiDetails);

           IndividualCustomerDetails updatedMandi = individualCustomerRepository.save(mandiDetails);
           return modelMapper.map(updatedMandi, IndividualCustomerDto.class);
       }
    
    //count the total customerlist
    public long countCustomer()
	 {
		 return individualCustomerRepository.count();
	 }
}
