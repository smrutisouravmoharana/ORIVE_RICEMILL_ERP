package com.orive.Customer.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CorporationCustomerDto {

	private Long corporationCustomerId;
	private String businessName;
	private String customerName;
	private String emailAddress;
	private String gender;
	private String webUrl;
	private String fax;
	private String gstin;
	private Long mobileNo;
	private String panNumber;
	private Long adharNumber;
	private String streetAddress1;
	private String streetAddress2;
	private String city;
	private String state;
	private Long zipCode;
	private String country;
	private String typeOfAddress;
	private String accountHolderName;
    private String bankName;
    private String accountBranch;
    private Long bankAccountName;
    private String bankAccountType;
    private String swiftOrBicCode;
    private String bankRoutingOrSortCode;
    private String ifscCode;
    private String micrNumber;
    private String currency;
    private Long creditLimit;
    private String taxId;
    private boolean termsAndConditions;
}
