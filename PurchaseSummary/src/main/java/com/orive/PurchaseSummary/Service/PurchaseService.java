package com.orive.PurchaseSummary.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.PurchaseSummary.Dto.PurchaseProduct;
import com.orive.PurchaseSummary.Dto.Purchase;
import com.orive.PurchaseSummary.Entity.PurchaseProductDetails;
import com.orive.PurchaseSummary.Entity.PurchaseDetails;
import com.orive.PurchaseSummary.Repository.PurchaseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PurchaseService {
	
	private Logger logger=LoggerFactory.getLogger(PurchaseService.class);

	@Autowired
	private PurchaseRepository gowdownRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Purchase createGowdown(Purchase gowdown) {
        PurchaseDetails gowdownDetails = modelMapper.map(gowdown, PurchaseDetails.class);

        // Make sure to associate each AddressDTO with the employeeEntity
        for (PurchaseProduct godownProduct : gowdown.getGodownProducts()) {
        	PurchaseProductDetails godownProductDetails = modelMapper.map(godownProduct, PurchaseProductDetails.class);
        	godownProductDetails.setGowdownDetails(gowdownDetails);
            gowdownDetails.getGodownProductsDetails().add(godownProductDetails);
        }

        PurchaseDetails details = gowdownRepository.save(gowdownDetails);

        return modelMapper.map(details, Purchase.class);
    }
	
	 public List<Purchase> getAllGowdown() {
	        List<PurchaseDetails> gowdownDetails = gowdownRepository.findAll();
	        return gowdownDetails.stream()
	                       .map(gowdown -> modelMapper.map(gowdown, Purchase.class))
	                       .collect(Collectors.toList());
	    }
	
	 public List<Purchase> getGodownById(List<Long> purchaseId) {
	        List<PurchaseDetails> gowdownDetails = gowdownRepository.findAllById(purchaseId);

	        return gowdownDetails.stream()
	                       .map(mandi -> modelMapper.map(mandi, Purchase.class))
	                       .collect(Collectors.toList());
	    }
	
	 public void deleteGodown(Long purchaseId) {
	        PurchaseDetails existingGowdown = gowdownRepository.findById(purchaseId)
	                                                  .orElseThrow(() -> new EntityNotFoundException("purchaseId not found"));

	        gowdownRepository.deleteById(purchaseId);
	    }	
	 public Purchase updateGowdown(Long purchaseId, Purchase updatedGodownDTO) {
	        PurchaseDetails Entity = gowdownRepository.findById(purchaseId)
	                .orElseThrow(() -> new EntityNotFoundException("purchaseId not found"));

	        Entity.setSupplierName(updatedGodownDTO.getSupplierName());
	        // Update other fields as needed
	        
	        // Update addresses
	        Entity.getGodownProductsDetails().clear();
	        for (PurchaseProduct DTO : updatedGodownDTO.getGodownProducts()) {
	            PurchaseProductDetails productEntity = modelMapper.map(DTO, PurchaseProductDetails.class);
	            productEntity.setGowdownDetails(Entity);
	            Entity.getGodownProductsDetails().add(productEntity);
	        }

	        PurchaseDetails updated = gowdownRepository.save(Entity);

	        return modelMapper.map(updated, Purchase.class);
	    }
}
