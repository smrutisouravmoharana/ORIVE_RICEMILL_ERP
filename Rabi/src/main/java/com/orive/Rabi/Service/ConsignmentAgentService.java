package com.orive.Rabi.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Rabi.Dto.ConsignmentAgentDto;
import com.orive.Rabi.Entity.ConsignmentAgentEntity;
import com.orive.Rabi.Repository.ConsignmentAgentRepository;


@Service
public class ConsignmentAgentService {
	
private static final Logger logger=LoggerFactory.getLogger(ConsignmentAgentService.class);
	
	@Autowired
	private ConsignmentAgentRepository consignmentAgentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	


    // Create
    public ConsignmentAgentDto createConsignmentAgent(ConsignmentAgentDto consignmentAgentDto) {
    	ConsignmentAgentEntity consignmentAgentEntity = convertToEntity(consignmentAgentDto);
    	ConsignmentAgentEntity savedConsignmentAgent= consignmentAgentRepository.save(consignmentAgentEntity);
        logger.info("Created ConsignmentAgent with ID: {}", savedConsignmentAgent.getConsignmentAgentId());
        return convertToDTO(savedConsignmentAgent);
    }

    // Read
    public List<ConsignmentAgentDto> getAllConsignmentAgents() {
        List<ConsignmentAgentEntity> consignmentAgent = consignmentAgentRepository.findAll();
        logger.info("Retrieved {} ConsignmentAgent from the database", consignmentAgent.size());
        return consignmentAgent.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by ConsignmentAgentId
    public Optional<ConsignmentAgentDto> getConsignmentAgentId(Long consignmentAgentId) {
        Optional<ConsignmentAgentEntity> consignmentAgent = consignmentAgentRepository.findById(consignmentAgentId);
        if (consignmentAgent.isPresent()) {
            return Optional.of(convertToDTO(consignmentAgent.get()));
        } else {
            logger.warn("ConsignmentAgent with ID {} not found", consignmentAgentId);
            return Optional.empty();
        }
    }
    
    // Update list by id
    public ConsignmentAgentDto updateConsignmentAgent(Long consignmentAgentId, ConsignmentAgentDto updatedConsignmentAgentDto) {
        Optional<ConsignmentAgentEntity> existingConsignmentAgentOptional = consignmentAgentRepository.findById(consignmentAgentId);
        if (existingConsignmentAgentOptional.isPresent()) {
        	ConsignmentAgentEntity existingConsignmentAgent = existingConsignmentAgentOptional.get();
            modelMapper.map(updatedConsignmentAgentDto, existingConsignmentAgent);
            ConsignmentAgentEntity updatedConsignmentAgent = consignmentAgentRepository.save(existingConsignmentAgent);
            logger.info("Updated ConsignmentAgent with ID: {}", updatedConsignmentAgent.getConsignmentAgentId());
            return convertToDTO(updatedConsignmentAgent);
        } else {
            logger.warn("ConsignmentAgent with ID {} not found for update", consignmentAgentId);
            return null;
        }
    }
    

    // Delete
    public void deleteConsignmentAgent(Long consignmentAgentId) {
        consignmentAgentRepository.deleteById(consignmentAgentId);
        logger.info("Deleted ConsignmentAgent with ID: {}", consignmentAgentId);
    }

    //count the total ConsignmentAgent
    public long countConsignmentAgent()
	 {
		 return consignmentAgentRepository.count();
	 }
    
    
    // Helper method to convert ConsignmentAgentDTo to ConsignmentAgentEntity
    private ConsignmentAgentEntity convertToEntity(ConsignmentAgentDto consignmentAgentDto ) {
        return modelMapper.map(consignmentAgentDto, ConsignmentAgentEntity.class);
    }

    // Helper method to convert ConsignmentAgentEntity entity to ConsignmentAgentDTo
    private ConsignmentAgentDto convertToDTO(ConsignmentAgentEntity consignmentAgentEntity) {
        return modelMapper.map(consignmentAgentEntity, ConsignmentAgentDto.class);
    }
    


}
