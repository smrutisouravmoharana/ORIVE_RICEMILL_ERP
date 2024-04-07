package com.orive.Transportation.Dto;

import java.io.Serializable;
import java.util.Date;

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
public class Transportation{

	private Long transportationId;
	private Long serialNo;
	private Long referenceNo;
	private String nameOfTransporterOffice;
	private String gstin;
	private String ownerName;
	private String panNo;
	private String adhaarNo;
	private Long phoneNo;
	private Long mobileNo;
	private String country;
	private String state;
	private String city;
	private Long postalOrZipCode;
	private String address;
	private String driverName;
	private String driverPanNo;
	private Long driverMobileNO;
	private String licenceNo;
	private String rcNo;
	private String vechicleType;
	private String weightmentDetails;
	private String driverAddress;
	private String approvedBy;
	private String clearedBy;
	private Boolean date;
}
