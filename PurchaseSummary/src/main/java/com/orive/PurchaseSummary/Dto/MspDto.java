package com.orive.PurchaseSummary.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MspDto {
	
    private Long mspId;
	private String dateOfRegistration;
	private String mspYear;
	private String season;
	private String crops;
	private int cropsUnit;
	private double mspPrice;
	private String country;
	private String State;
	private String dist;
	private String status;

}
