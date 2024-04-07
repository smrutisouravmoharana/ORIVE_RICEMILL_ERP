package com.orive.Customer.Dto;

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
public class IndividualCustomerDto {

	private Long individualCustomerId;
	private String businessName;
	private String customerName;
	private String emailAddress;
	private String gender;
	private String fax;
	private String gstinNo;
	private Long mobileNo;
	private String panNumber;
	private Long adharNumber;
	private String streetAddress1;
	private String streetAddress2;
	private String city;
	private String state;
	private Long postalOrZipCode;
	private String country;
	private String typeOfAddress;
	private String accountHolderName;
    private String bankName;
    private String bankBranch;
    private Long bankAccountNumber;
    private String bankAccountType;
    private String swiftOrBicCode;
    private String bankRoutingOrSortCode;
    private String ifscCode;
    private String micrNumber;
    private String currency;
    private Long creditLimit;
    private String taxId;
    private String approvedBy;
    private String clearedBy;
    private String date;
    private boolean termsAndConditions;
	
}
