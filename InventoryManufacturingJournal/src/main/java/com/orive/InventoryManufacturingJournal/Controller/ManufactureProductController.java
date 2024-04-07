package com.orive.InventoryManufacturingJournal.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.InventoryManufacturingJournal.Entity.ManufactureProductEntity;
import com.orive.InventoryManufacturingJournal.Service.ManufactureProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/manufacture")
public class ManufactureProductController {

	@Autowired
	private ManufactureProductService  manufactureProductService;
	
	@PostMapping(value = "/save")
	public ManufactureProductEntity save(@RequestBody ManufactureProductEntity manufactureProductEntity)
	{
		return manufactureProductService.save(manufactureProductEntity);
	}
	
	@GetMapping(value = "/get")
	public List<ManufactureProductEntity> findAll()
	{
		return manufactureProductService.findAll();
	}
	
	@GetMapping(value = "/getById/{manufactureproductId}")
	public Optional<ManufactureProductEntity> findById(@PathVariable("manufactureproductId") Long manufactureproductId)
	{
		return manufactureProductService.findById(manufactureproductId);
	}
	
	@DeleteMapping(value = "/delete/{manufactureproductId}")
	public void deleteById(@PathVariable("manufactureproductId") Long manufactureproductId)
	{
		manufactureProductService.deleteById(manufactureproductId);
	}
}
