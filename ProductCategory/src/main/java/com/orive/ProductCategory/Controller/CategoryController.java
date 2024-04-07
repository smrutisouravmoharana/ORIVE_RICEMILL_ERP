package com.orive.ProductCategory.Controller;

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

import com.orive.ProductCategory.Dto.CategoryDto;
import com.orive.ProductCategory.Service.CategoryService;


@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	private Logger logger=LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(value = "/create")
    public CategoryDto createProduct(@RequestBody CategoryDto productDTO) {
        return categoryService.createUnit(productDTO);
    }
	
	@GetMapping(value = "/getall")
	public List<CategoryDto> getAllProduct()
	{
		return categoryService.getAllUnit();
	}

    @GetMapping(value = "/{categoryId}")
    public CategoryDto getProduct(@PathVariable Long categoryId) {
        return categoryService.getUnitById(categoryId);
    }

    @PutMapping(value = "/update/{categoryId}")
    public CategoryDto updateProduct(@PathVariable Long categoryId, @RequestBody CategoryDto productDTO) {
        return categoryService.updateUnit(categoryId, productDTO);
    }

    @DeleteMapping(value = "/delete/{categoryId}")
    public void deleteProduct(@PathVariable Long categoryId) {
        categoryService.deleteUnit(categoryId);
    }
    
    @GetMapping(value = "/getname/{categoryName}")
    public List<CategoryDto> getProduct(@PathVariable String categoryName) {
        return categoryService.getUnitByName(categoryName);
    }
}
