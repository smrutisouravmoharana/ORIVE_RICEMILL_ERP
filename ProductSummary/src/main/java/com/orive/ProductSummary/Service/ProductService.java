package com.orive.ProductSummary.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.orive.ProductSummary.Dto.ProductDto;
import com.orive.ProductSummary.Entity.Product;
import com.orive.ProductSummary.Repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	
	private Logger logger=LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ProductDto createProduct(ProductDto productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }
	
	public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            // Handle not found
            return null;
        }
        return modelMapper.map(product, ProductDto.class);
    }

    public ProductDto updateProduct(Long productId, ProductDto productDTO) {
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct == null) {
            // Handle not found
            return null;
        }
        modelMapper.map(productDTO, existingProduct); // Update the existing entity
        Product updatedProduct = productRepository.save(existingProduct);
        return modelMapper.map(updatedProduct, ProductDto.class);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
	
}
