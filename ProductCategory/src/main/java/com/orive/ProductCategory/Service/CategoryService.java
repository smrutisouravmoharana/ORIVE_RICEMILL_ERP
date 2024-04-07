package com.orive.ProductCategory.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.ProductCategory.Dto.CategoryDto;
import com.orive.ProductCategory.Entity.CategoryDetails;
import com.orive.ProductCategory.Repository.CategoryRepository;


@Service
public class CategoryService {

	private Logger logger=LoggerFactory.getLogger(CategoryService.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CategoryDto createUnit(CategoryDto productDTO) {
        CategoryDetails product = modelMapper.map(productDTO, CategoryDetails.class);
        CategoryDetails savedProduct = categoryRepository.save(product);
        return modelMapper.map(savedProduct, CategoryDto.class);
    }
	
	public List<CategoryDto> getAllUnit() {
        List<CategoryDetails> products = categoryRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, CategoryDto.class))
                .collect(Collectors.toList());
    }

    public CategoryDto getUnitById(Long categoryId) {
        CategoryDetails product = categoryRepository.findById(categoryId).orElse(null);
        if (product == null) {
            // Handle not found
            return null;
        }
        return modelMapper.map(product, CategoryDto.class);
    }

    public CategoryDto updateUnit(Long categoryId, CategoryDto productDTO) {
        CategoryDetails existingProduct = categoryRepository.findById(categoryId).orElse(null);
        if (existingProduct == null) {
            // Handle not found
            return null;
        }
        modelMapper.map(productDTO, existingProduct); // Update the existing entity
        CategoryDetails updatedProduct = categoryRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, CategoryDto.class);
    }

    public void deleteUnit(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
    
    public List<CategoryDto> getUnitByName(String categoryName) {
		 logger.info("Fetching suppliers by name");
	        List<CategoryDetails> mandiDetails = categoryRepository.findByCategoryName(categoryName);

	        return mandiDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, CategoryDto.class))
	                       .collect(Collectors.toList());
	    }
}
