package com.orive.ProductUnit.Controller;

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


import com.orive.ProductUnit.Dto.UnitDto;
import com.orive.ProductUnit.Service.ProductUnitService;

@RestController
@RequestMapping(value = "/unit")
public class ProductUnitController {

	private Logger logger=LoggerFactory.getLogger(ProductUnitController.class);
	
	@Autowired
	private ProductUnitService productUnitService;
	
	@PostMapping(value = "/create")
    public UnitDto createProduct(@RequestBody UnitDto productDTO) {
        return productUnitService.createUnit(productDTO);
    }
	
	@GetMapping(value = "/getall")
	public List<UnitDto> getAllProduct()
	{
		return productUnitService.getAllUnit();
	}

    @GetMapping(value = "/{unitId}")
    public UnitDto getProduct(@PathVariable Long unitId) {
        return productUnitService.getUnitById(unitId);
    }

    @PutMapping(value = "/update/{unitId}")
    public UnitDto updateProduct(@PathVariable Long unitId, @RequestBody UnitDto productDTO) {
        return productUnitService.updateUnit(unitId, productDTO);
    }

    @DeleteMapping(value = "/delete/{unitId}")
    public void deleteProduct(@PathVariable Long unitId) {
        productUnitService.deleteUnit(unitId);
    }
    
    @GetMapping(value = "/getname/{unitName}")
    public List<UnitDto> getProduct(@PathVariable String unitName) {
        return productUnitService.getUnitByName(unitName);
    }
}
