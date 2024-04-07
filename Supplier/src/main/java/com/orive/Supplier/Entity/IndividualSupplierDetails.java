package com.orive.Supplier.Entity;



import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "individual_supplier")
public class IndividualSupplierDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long individualSupplierId;
	
	@Column(name = "business_name")
	private String personOfContact;
	
	@Column(name = "supplier_name")
	private String supplierName;
	
	@Column(name = "gstin")
	private Long gstin;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	
	@Column(name = "mobile_no")
	private Long mobileNo;
	
	@Column(name = "land_line_no")
	private Long landLineNo;
	
	@Column(name = "kisan_card_no")
	private String kisanCardNo;
	
	@Column(name = "date_of_registartion")
	private Date dateOfRegistartion;
	
	@Column(name = "pan_number")
	private String panNumber;
	
	@Column(name = "adhar_number")
	private Long adharNumber;
	
	@Column(name = "street_address_1")
	private String streetAddress1;
	
	@Column(name = "street_address_2")
	private String streetAddress2;
	
	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private Long zipCode;
	
	@Column(name = "country")
	private String country;
	
    @Column(name = "type_of_address") 
	private String typeOfAddress;
	
    @Column(name = "account_holder_name")
	private String accountHolderName;
    
    @Column(name = "bank_name")
    private String bankName;
    
    @Column(name = "bank_branch")
    private String bankBranch;
    
    @Column(name = "bank_account_number")
    private Long bankAccountNumber;
    
    @Column(name = "bill_credit_limit")
    private Long billCreditLimit;
    
    @Column(name = "no_of_credit_days")
    private Long noOfCreditDays;
    
    @Column(name = "credit_limit")
    private Long CreditLimit;
    
    @Column(name = "no_of_pending_bills")
    private Long noOfPendingBills;
    
    @Column(name = "billing_series")
    private String billingSeries;
    
    @Column(name = "purchase_series")
    private String purchaseSeries;
    
    @Column(name = "debit_or_credit")
    private String debitOrCredit;
    
    @Column(name = "opening_balance")
    private Long openingBalance;
    
    @Column(name = "bank_account_type")
    private String bankAccountType;
    
    @Column(name = "ifsc_code")
    private String ifscCode;
    
    @Column(name = "approved_by")
    private String approvedBy;
    
    @Column(name = "cleared_by")
    private String clearedBy;
    
    @Column(name = "date_of_approval")
    private Date dateOfApproval;
    
    @Column(name = "terms_and_conditions")
    private boolean termsAndConditions;
       
    
}
