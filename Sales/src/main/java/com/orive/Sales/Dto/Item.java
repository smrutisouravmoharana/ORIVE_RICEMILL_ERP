package com.orive.Sales.Dto;

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
public class Item {

    private Long saleItemId;
	
	private String productName;
	
	private String description;
	
	private String batchNumber;
	
	private double avgQuantity;
	
	private String unit;
	
	private double quantity;
	
	private double rate;
	
	private double discount;
	
	private double discountValue;
	
	private double vat;
	
	private double vatValue;
	
	private double total;
}
