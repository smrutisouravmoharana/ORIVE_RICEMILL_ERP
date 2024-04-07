package com.orive.PurchaseSummary.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.PurchaseSummary.Dto.MspDto;
import com.orive.PurchaseSummary.Entity.MspEntity;
import com.orive.PurchaseSummary.Repository.MspRepository;


@Service
public class MspService {
	
	private static final Logger logger= LoggerFactory.getLogger(MspService.class);
	
	@Autowired
	private MspRepository mspRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public MspDto createMsp(MspDto mspDto) {
        MspEntity mspEntity = convertToEntity(mspDto);
        MspEntity savedMsp = mspRepository.save(mspEntity);
        logger.info("Created Msp with ID: {}", savedMsp.getMspId());
        return convertToDTO(savedMsp);
    }

    // Read
    public List<MspDto> getAllMsp() {
        List<MspEntity> msp = mspRepository.findAll();
        logger.info("Retrieved {} Msp from the database", msp.size());
        return msp.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by MspId
    public Optional<MspDto> getMspById(Long MspId) {
        Optional<MspEntity> msp = mspRepository.findById(MspId);
        if (msp.isPresent()) {
            return Optional.of(convertToDTO(msp.get()));
        } else {
            logger.warn("Msp with ID {} not found", MspId);
            return Optional.empty();
        }
    }
    

    
 // Update list by id
    public MspDto updateMsp(Long MspId, MspDto updatedMspDto) {
        Optional<MspEntity> existingMspOptional = mspRepository.findById(MspId);
        if (existingMspOptional.isPresent()) {
        	MspEntity existingMsp = existingMspOptional.get();
            modelMapper.map(updatedMspDto, existingMsp);
            MspEntity updatedMsp = mspRepository.save(existingMsp);
            logger.info("Updated Msp with ID: {}", updatedMsp.getMspId());
            return convertToDTO(updatedMsp);
        } else {
            logger.warn("Msp with ID {} not found for update", MspId);
            return null;
        }
    }
    

    // Delete
    public void deleteMsp(Long MspId) {
        mspRepository.deleteById(MspId);
        logger.info("Deleted Msp with ID: {}", MspId);
    }

    //count the total Msplist
    public long countMsp()
	 {
		 return mspRepository.count();
	 }
    
	// Helper method to convert MspDTo to MspEntity
    private MspEntity convertToEntity(MspDto mspDto)
    {
    	return modelMapper.map(mspDto, MspEntity.class);
    }

    // Helper method to convert MspEntity entity to MspDTo
    private MspDto convertToDTO(MspEntity mspEntity) {
        return modelMapper.map(mspEntity, MspDto.class);
    }  
}
