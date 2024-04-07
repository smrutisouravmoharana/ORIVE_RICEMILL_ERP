package com.orive.InventoryManufacturingJournal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.InventoryManufacturingJournal.Entity.ManufactureProductEntity;
import com.orive.InventoryManufacturingJournal.Repository.ManufactureProductRepository;

@Service
public class ManufactureProductService {

	@Autowired
	private ManufactureProductRepository manufactureProductRepository;
	
	
	public ManufactureProductEntity save(ManufactureProductEntity manufactureProductEntity)
	{
		return manufactureProductRepository.save(manufactureProductEntity);
	}
	
	public List<ManufactureProductEntity> findAll()
	{
		return manufactureProductRepository.findAll();
	}
	
	public Optional<ManufactureProductEntity> findById(Long manufactureproductId)
	{
		return manufactureProductRepository.findById(manufactureproductId);
	}
	
	public void deleteById(Long manufactureproductId)
	{
		manufactureProductRepository.deleteById(manufactureproductId);
	}
}
