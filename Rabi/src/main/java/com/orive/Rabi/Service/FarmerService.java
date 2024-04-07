package com.orive.Rabi.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Rabi.Dto.FarmerDto;
import com.orive.Rabi.Entity.FarmerEntity;
import com.orive.Rabi.Repository.FarmerRepository;


@Service
public class FarmerService {
	
	private static final Logger logger=LoggerFactory.getLogger(FarmerService.class);
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
    // Create
    public FarmerDto createFarmer(FarmerDto farmerDto) {
    	FarmerEntity farmerEntity = convertToEntity(farmerDto);
    	FarmerEntity savedFarmer= farmerRepository.save(farmerEntity);
        logger.info("Created Farmer with ID: {}", savedFarmer.getFarmerId());
        return convertToDTO(savedFarmer);
    }

    // Read
    public List<FarmerDto> getAllFarmers() {
        List<FarmerEntity> farmers = farmerRepository.findAll();
        logger.info("Retrieved {} Farmer from the database", farmers.size());
        return farmers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by FarmerId
    public Optional<FarmerDto> getFarmerId(Long farmerId) {
        Optional<FarmerEntity> farmers = farmerRepository.findById(farmerId);
        if (farmers.isPresent()) {
            return Optional.of(convertToDTO(farmers.get()));
        } else {
            logger.warn("Farmer with ID {} not found", farmerId);
            return Optional.empty();
        }
    }
    
    // Update list by id
    public FarmerDto updateFarmer(Long farmerId, FarmerDto updatedFarmerDto) {
        Optional<FarmerEntity> existingFarmerOptional = farmerRepository.findById(farmerId);
        if (existingFarmerOptional.isPresent()) {
        	FarmerEntity existingFarmer = existingFarmerOptional.get();
            modelMapper.map(updatedFarmerDto, existingFarmer);
            FarmerEntity updatedFarmer = farmerRepository.save(existingFarmer);
            logger.info("Updated Farmer with ID: {}", updatedFarmer.getFarmerId());
            return convertToDTO(updatedFarmer);
        } else {
            logger.warn("Farmer with ID {} not found for update", farmerId);
            return null;
        }
    }
    

    // Delete
    public void deleteFarmer(Long farmerId) {
        farmerRepository.deleteById(farmerId);
        logger.info("Deleted Farmer with ID: {}", farmerId);
    }

    //count the total Farmer
    public long countFarmer()
	 {
		 return farmerRepository.count();
	 }
    
    
    // Helper method to convert FarmerDTo to FarmerEntity
    private FarmerEntity convertToEntity(FarmerDto farmerDto  ) {
        return modelMapper.map(farmerDto, FarmerEntity.class);
    }

    // Helper method to convert FarmerEntity entity to FarmerDTo
    private FarmerDto convertToDTO(FarmerEntity farmerEntity) {
        return modelMapper.map(farmerEntity, FarmerDto.class);
    }
    


}
