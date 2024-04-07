package com.orive.Stock.Entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PurchaseProduct {

    private Long productId;
	
	private String productName;
	
	private double stockOrQuantity;
	
	private LocalDate expiryDate;
	
	private String batchNumber;
	
	private double quantity;
	
	private double rate;

	private double discountInPercentage;
	
	private double discountValue;
	
	private double vatInPercentage;
	
	private double vatValue;
	
	private double total;
}
