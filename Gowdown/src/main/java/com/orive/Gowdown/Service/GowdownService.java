package com.orive.Gowdown.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Gowdown.Dto.GodownProduct;
import com.orive.Gowdown.Dto.Gowdown;
import com.orive.Gowdown.Entity.GodownProductDetails;
import com.orive.Gowdown.Entity.GowdownDetails;
import com.orive.Gowdown.Repository.GowdownRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class GowdownService {
	
	private Logger logger=LoggerFactory.getLogger(GowdownService.class);

	@Autowired
	private GowdownRepository gowdownRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Gowdown createGowdown(Gowdown gowdown) {
        GowdownDetails gowdownDetails = modelMapper.map(gowdown, GowdownDetails.class);

        // Make sure to associate each AddressDTO with the employeeEntity
        for (GodownProduct godownProduct : gowdown.getGodownProducts()) {
        	GodownProductDetails godownProductDetails = modelMapper.map(godownProduct, GodownProductDetails.class);
        	godownProductDetails.setGowdownDetails(gowdownDetails);
            gowdownDetails.getGodownProductsDetails().add(godownProductDetails);
        }

        GowdownDetails details = gowdownRepository.save(gowdownDetails);

        return modelMapper.map(details, Gowdown.class);
    }
	
	 public List<Gowdown> getAllGowdown() {
	        List<GowdownDetails> gowdownDetails = gowdownRepository.findAll();
	        return gowdownDetails.stream()
	                       .map(gowdown -> modelMapper.map(gowdown, Gowdown.class))
	                       .collect(Collectors.toList());
	    }
	
	 public List<Gowdown> getGodownById(List<Long> godownId) {
	        List<GowdownDetails> gowdownDetails = gowdownRepository.findAllById(godownId);

	        return gowdownDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, Gowdown.class))
	                       .collect(Collectors.toList());
	    }
	
	 public void deleteGodown(Long godownId) {
	        GowdownDetails existingGowdown = gowdownRepository.findById(godownId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("godownId not found"));

	        gowdownRepository.deleteById(godownId);
	    }	
	 public Gowdown updateGowdown(Long godownId, Gowdown updatedGodownDTO) {
	        GowdownDetails Entity = gowdownRepository.findById(godownId)
	                .orElseThrow(() -> new EntityNotFoundException("GowdownId not found"));

	        Entity.setGodownName(updatedGodownDTO.getGodownName());
	        // Update other fields as needed
	        
	        // Update addresses
	        Entity.getGodownProductsDetails().clear();
	        for (GodownProduct DTO : updatedGodownDTO.getGodownProducts()) {
	            GodownProductDetails productEntity = modelMapper.map(DTO, GodownProductDetails.class);
	            productEntity.setGowdownDetails(Entity);
	            Entity.getGodownProductsDetails().add(productEntity);
	        }

	        GowdownDetails updated = gowdownRepository.save(Entity);

	        return modelMapper.map(updated, Gowdown.class);
	    }
}
