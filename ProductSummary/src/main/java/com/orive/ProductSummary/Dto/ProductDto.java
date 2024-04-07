package com.orive.ProductSummary.Dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ProductDto {

	private Long productId;
	
	private String productName;
	
	private String categoryName;
	
	private double salePrice;
	
	private double costPrice;
	
	private String supplierName;
	
	private String sn;
	
	private String model;
	
	private String unitName;;
	
	private String productDetails;
	
	private String productVatPercentage;
}
