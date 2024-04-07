package com.orive.Kharif.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Kharif.Dto.FarmerDto;
import com.orive.Kharif.Dto.TraderDto;
import com.orive.Kharif.Entity.FarmerEntity;
import com.orive.Kharif.Entity.TraderEntity;
import com.orive.Kharif.Repository.TraderRepository;

@Service
public class TraderService {
	
	private static final Logger logger= LoggerFactory.getLogger(TraderService.class);
	
	@Autowired
	private TraderRepository traderRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public TraderDto createTrader(TraderDto traderDto) {
    	TraderEntity traderEntity = convertToEntity(traderDto);
    	TraderEntity savedTrader= traderRepository.save(traderEntity);
        logger.info("Created Trader with ID: {}", savedTrader.getTraderId());
        return convertToDTO(savedTrader);
    }

    // Read
    public List<TraderDto> getAllTraders() {
        List<TraderEntity> traders = traderRepository.findAll();
        logger.info("Retrieved {} Trader from the database", traders.size());
        return traders.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by TraderId
    public Optional<TraderDto> getTraderId(Long traderId) {
        Optional<TraderEntity> traders = traderRepository.findById(traderId);
        if (traders.isPresent()) {
            return Optional.of(convertToDTO(traders.get()));
        } else {
            logger.warn("Trader with ID {} not found", traderId);
            return Optional.empty();
        }
    }
    
    // Update list by id
    public TraderDto updateTrader(Long traderId, TraderDto updatedTraderDto) {
        Optional<TraderEntity> existingTraderOptional = traderRepository.findById(traderId);
        if (existingTraderOptional.isPresent()) {
        	TraderEntity existingTrader = existingTraderOptional.get();
            modelMapper.map(updatedTraderDto, existingTrader);
            TraderEntity updatedFarmer = traderRepository.save(existingTrader);
            logger.info("Updated Trader with ID: {}", updatedFarmer.getTraderId());
            return convertToDTO(updatedFarmer);
        } else {
            logger.warn("Trader with ID {} not found for update", traderId);
            return null;
        }
    }
    

    // Delete
    public void deleteTrader(Long traderId) {
        traderRepository.deleteById(traderId);
        logger.info("Deleted Trader with ID: {}", traderId);
    }

    //count the total Trader
    public long countTrader()
	 {
		 return traderRepository.count();
	 }
    
    
    // Helper method to convert TraderDTo to TraderEntity
    private TraderEntity convertToEntity(TraderDto traderDto   ) {
        return modelMapper.map(traderDto, TraderEntity.class);
    }

    // Helper method to convert TraderEntity entity to TraderDTo
    private TraderDto convertToDTO(TraderEntity traderEntity) {
        return modelMapper.map(traderEntity, TraderDto.class);
    }
    

}
