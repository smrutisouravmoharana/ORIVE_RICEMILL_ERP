package com.orive.Sales.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Sales.Dto.Sales;
import com.orive.Sales.Service.SaleOrderService;

@RestController
@RequestMapping(value = "/sale")
public class SaleOrderController {

	private Logger logger=LoggerFactory.getLogger(SaleOrderController.class);
	
	@Autowired
	private SaleOrderService saleOrderService;
	
	// Create a new Sale Order
    @PostMapping(value = "/create")
    public ResponseEntity<Sales> createSaleOrder(@RequestBody Sales salesDto) {
        Sales createdSale = saleOrderService.createSaleOrder(salesDto);
        return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
    }

    // Get a Sale Order by ID
    @GetMapping("/getbyid/{saleId}")
    public ResponseEntity<Sales> getSaleOrderById(@PathVariable Long saleId) {
        Sales sale = saleOrderService.getSaleOrderById(saleId);
        return ResponseEntity.ok(sale);
    }

    // Get all Sale Orders
    @GetMapping(value = "/get")
    public ResponseEntity<List<Sales>> getAllSaleOrders() {
        List<Sales> saleOrders = saleOrderService.getAllSaleOrders();
        return ResponseEntity.ok(saleOrders);
    }

    // Update a Sale Order by ID
    @PutMapping("/update/{saleId}")
    public ResponseEntity<Sales> updateSaleOrder(@PathVariable Long saleId, @RequestBody Sales salesDto) {
        Sales updatedSale = saleOrderService.updateSaleOrder(saleId, salesDto);
        return ResponseEntity.ok(updatedSale);
    }

    // Delete a Sale Order by ID
    @DeleteMapping("/delete/{saleId}")
    public ResponseEntity<Void> deleteSaleOrder(@PathVariable Long saleId) {
        saleOrderService.deleteSaleOrder(saleId);
        return ResponseEntity.noContent().build();
    }
}
