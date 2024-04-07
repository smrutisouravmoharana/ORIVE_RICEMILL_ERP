package com.orive.Supplier.Dto;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IndividualSupplierDto implements Serializable{
	
	private Long individualSupplierId;
	private String personOfContact;
	private String supplierName;
	private Long gstin;
	private String emailAddress;
	private Long mobileNo;
	private Long landLineNo;
	private String kisanCardNo;
	private Date dateOfRegistartion;
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
    private String bankBranch;
    private Long bankAccountNumber;
    private Long billCreditLimit;
    private Long noOfCreditDays;
    private Long CreditLimit;
    private Long noOfPendingBills;
    private String billingSeries;
    private String purchaseSeries;
    private String debitOrCredit;
    private Long openingBalance;
    private String bankAccountType;
    private String ifscCode;
    private String approvedBy;
    private String clearedBy;
    private Date dateOfApproval;
    private boolean termsAndConditions;
}
