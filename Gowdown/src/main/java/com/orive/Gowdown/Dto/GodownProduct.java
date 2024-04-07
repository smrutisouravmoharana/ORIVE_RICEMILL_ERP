package com.orive.Gowdown.Dto;

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
public class GodownProduct {

    private Long productId;
		
	private String productName;

	private Date purchaseDate;
	
	private double productQuantity;
	
	private double pocketSize;
	
	private double noOfProductPocket;
	
	private double netQuantity;
}
