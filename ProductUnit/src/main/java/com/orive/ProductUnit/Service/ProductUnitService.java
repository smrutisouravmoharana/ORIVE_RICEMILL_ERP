package com.orive.ProductUnit.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.ProductUnit.Dto.UnitDto;
import com.orive.ProductUnit.Entity.UnitDetails;
import com.orive.ProductUnit.Repository.UnitRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductUnitService {
	
	private Logger logger=LoggerFactory.getLogger(ProductUnitService.class);

	@Autowired
	private UnitRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UnitDto createUnit(UnitDto productDTO) {
        UnitDetails product = modelMapper.map(productDTO, UnitDetails.class);
        UnitDetails savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, UnitDto.class);
    }
	
	public List<UnitDto> getAllUnit() {
        List<UnitDetails> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, UnitDto.class))
                .collect(Collectors.toList());
    }

    public UnitDto getUnitById(Long unitId) {
        UnitDetails product = productRepository.findById(unitId).orElse(null);
        if (product == null) {
            // Handle not found
            return null;
        }
        return modelMapper.map(product, UnitDto.class);
    }

    public UnitDto updateUnit(Long unitId, UnitDto productDTO) {
        UnitDetails existingProduct = productRepository.findById(unitId).orElse(null);
        if (existingProduct == null) {
            // Handle not found
            return null;
        }
        modelMapper.map(productDTO, existingProduct); // Update the existing entity
        UnitDetails updatedProduct = productRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, UnitDto.class);
    }

    public void deleteUnit(Long unitId) {
        productRepository.deleteById(unitId);
    }
    
    public List<UnitDto> getUnitByName(String unitName) {
		 logger.info("Fetching suppliers by name");
	        List<UnitDetails> mandiDetails = productRepository.findByUnitName(unitName);

	        return mandiDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, UnitDto.class))
	                       .collect(Collectors.toList());
	    }
	
}
