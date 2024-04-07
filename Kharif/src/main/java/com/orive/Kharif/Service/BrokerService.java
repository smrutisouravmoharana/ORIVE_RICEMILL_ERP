package com.orive.Kharif.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Kharif.Dto.BrokerDto;
import com.orive.Kharif.Entity.BrokerEntity;
import com.orive.Kharif.Repository.BrokerRepository;


@Service
public class BrokerService {
	
	private static final Logger logger=LoggerFactory.getLogger(BrokerService.class);
	
	@Autowired
	private BrokerRepository brokerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
//	private ObjectMapper objectMapper;

    // Create
    public BrokerDto createBroker(BrokerDto brokerDto) {
    	BrokerEntity brokerEntity = convertToEntity(brokerDto);
    	BrokerEntity savedBroker = brokerRepository.save(brokerEntity);
        logger.info("Created Broker with ID: {}", savedBroker.getBrokerId());
        return convertToDTO(savedBroker);
    }

    // Read
    public List<BrokerDto> getAllBrokers() {
        List<BrokerEntity> broker = brokerRepository.findAll();
        logger.info("Retrieved {} Broker from the database", broker.size());
        return broker.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by BrokerId
    public Optional<BrokerDto> getBrokerById(Long brokerId) {
        Optional<BrokerEntity> broker = brokerRepository.findById(brokerId);
        if (broker.isPresent()) {
            return Optional.of(convertToDTO(broker.get()));
        } else {
            logger.warn("Broker with ID {} not found", brokerId);
            return Optional.empty();
        }
    }
    
    // Update list by id
    public BrokerDto updateBroker(Long brokerId, BrokerDto updatedBrokerDto) {
        Optional<BrokerEntity> existingBrokerOptional = brokerRepository.findById(brokerId);
        if (existingBrokerOptional.isPresent()) {
        	BrokerEntity existingBroker = existingBrokerOptional.get();
            modelMapper.map(updatedBrokerDto, existingBroker);
            BrokerEntity updatedBroker = brokerRepository.save(existingBroker);
            logger.info("Updated Broker with ID: {}", updatedBroker.getBrokerId());
            return convertToDTO(updatedBroker);
        } else {
            logger.warn("Broker with ID {} not found for update", brokerId);
            return null;
        }
    }
    

    // Delete
    public void deleteBroker(Long brokerId) {
        brokerRepository.deleteById(brokerId);
        logger.info("Deleted Broker with ID: {}", brokerId);
    }

    //count the total Broker
    public long countBroker()
	 {
		 return brokerRepository.count();
	 }
    
    
    // Helper method to convert BrokerDTo to BrokerEntity
    private BrokerEntity convertToEntity(BrokerDto brokerDto) {
        return modelMapper.map(brokerDto, BrokerEntity.class);
    }

    // Helper method to convert BrokerEntity entity to BrokerDTo
    private BrokerDto convertToDTO(BrokerEntity brokerEntity) {
        return modelMapper.map(brokerEntity, BrokerDto.class);
    }
    

}
