package com.orive.Hr.Dto;

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
public class Employee {

    private Long employeeId;
	
	private String firstName;

	private String lastName;
	
    private String designationName;
	
	private Long phoneNumber;
	
	private String rateType;
	
	private double hourRatePerSalery;
	
	private String email;
	
	private String bloodGroup;
	
	private String address1;
	
	private String address2;
	
	private String country;
	
	private String city;

	private Long zipCode;
}
