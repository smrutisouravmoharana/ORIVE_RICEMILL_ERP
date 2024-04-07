package com.orive.Sales.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Sales.Dto.Sales;
import com.orive.Sales.Entity.SaleOrder;
import com.orive.Sales.Repository.SaleOrderRepository;

@Service
public class SaleOrderService {

	private Logger logger=LoggerFactory.getLogger(SaleOrderService.class);
	
	@Autowired
	private SaleOrderRepository saleOrderRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create operation
    public Sales createSaleOrder(Sales salesDto) {
    	logger.info("Sales Succesful register");
        SaleOrder saleOrder = modelMapper.map(salesDto, SaleOrder.class);
        SaleOrder savedSaleOrder = saleOrderRepository.save(saleOrder);
        return modelMapper.map(savedSaleOrder, Sales.class);
    }

    // Read operation by saleId
    public Sales getSaleOrderById(Long saleId) {
        Optional<SaleOrder> optionalSaleOrder = saleOrderRepository.findById(saleId);
        if (optionalSaleOrder.isPresent()) {
            SaleOrder saleOrder = optionalSaleOrder.get();
            return modelMapper.map(saleOrder, Sales.class);
        }
        throw new RuntimeException("Sale Order not found with id: " + saleId);
    }

    // Read operation for all sale orders
    public List<Sales> getAllSaleOrders() {
        List<SaleOrder> saleOrders = saleOrderRepository.findAll();
        return saleOrders.stream()
                .map(saleOrder -> modelMapper.map(saleOrder, Sales.class))
                .collect(Collectors.toList());
    }

    // Update operation
    public Sales updateSaleOrder(Long saleId, Sales salesDto) {
        Optional<SaleOrder> optionalSaleOrder = saleOrderRepository.findById(saleId);
        if (optionalSaleOrder.isPresent()) {
            SaleOrder saleOrder = optionalSaleOrder.get();
            modelMapper.map(salesDto, saleOrder);
            SaleOrder updatedSaleOrder = saleOrderRepository.save(saleOrder);
            return modelMapper.map(updatedSaleOrder, Sales.class);
        }
        throw new RuntimeException("Sale Order not found with id: " + saleId);
    }

    // Delete operation
    public void deleteSaleOrder(Long saleId) {
        saleOrderRepository.deleteById(saleId);
    }
}
