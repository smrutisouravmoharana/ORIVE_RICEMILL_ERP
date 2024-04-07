package com.orive.ProductSummary.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.ProductSummary.Dto.ProductDto;
import com.orive.ProductSummary.Service.ProductService;

@RestController
@RequestMapping(value = "/productcontroller")
public class ProductController {
	
	private Logger logger=LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/create")
    public ProductDto createProduct(@RequestBody ProductDto productDTO) {
        return productService.createProduct(productDTO);
    }
	
	@GetMapping(value = "/getall")
	public List<ProductDto> getAllProduct()
	{
		return productService.getAllProducts();
	}

    @GetMapping(value = "/{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PutMapping(value = "/update/{productId}")
    public ProductDto updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDTO) {
        return productService.updateProduct(productId, productDTO);
    }

    @DeleteMapping(value = "/delete/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}
