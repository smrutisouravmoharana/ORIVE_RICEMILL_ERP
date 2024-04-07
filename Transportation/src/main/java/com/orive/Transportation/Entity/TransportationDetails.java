package com.orive.Transportation.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "transportation")
public class TransportationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transportationId;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "serial_no")
	private Long serialNo;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reference_no")
	private Long referenceNo;
	
	@Column(name = "name_of_transporter_office")
	private String nameOfTransporterOffice;
	
	@Column(name = "gstin")
	private String gstin;
	
	@Column(name = "owner_name")
	private String ownerName;
	
	@Column(name = "pan_no")
	private String panNo;
	
	@Column(name = "adhaar_no")
	private String adhaarNo;
	
	@Column(name = "phone_no")
	private Long phoneNo;
	
	@Column(name = "mobile_no")
	private Long mobileNo;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal_or_zip_code")
	private Long postalOrZipCode;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "driver_name")
	private String driverName;
	
	@Column(name = "driver_pan_no")
	private String driverPanNo;
	
	@Column(name = "driver_mobile_nO")
	private Long driverMobileNO;
	
	@Column(name = "licence_no")
	private String licenceNo;
	
	@Column(name = "rc_no")
	private String rcNo;
	
	@Column(name = "vechicle_type")
	private String vechicleType;
	
	@Column(name = "weightment_details")
	private String weightmentDetails;
	
	@Column(name = "driver_address")
	private String driverAddress;
	
	@Column(name = "approved_by")
	private String approvedBy;
	
	@Column(name = "cleared_by")
	private String clearedBy;
	
	@Column(name = "date")
	private Boolean date;
}
