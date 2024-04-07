package com.orive.Sales.Dto;

import java.util.Date;
import java.util.List;

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
public class Sales {

    private Long saleId;
	
	private String customerName;
	
	private Date saleDate;
	
	private double saleDiscount;
	
	private double totalDiscount;
	
	private double totalVat;
	
	private double shippingCost;
	
	private double grandTotal;
	
	private double previous;
	
	private double netTotal;
	
	private double paidAmount;
	
	private double due;
	
	private double change;
	
	private String paymentType;
	
	private List<Item> items;
}
