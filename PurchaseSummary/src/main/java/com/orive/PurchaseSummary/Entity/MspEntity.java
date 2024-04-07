package com.orive.PurchaseSummary.Entity;

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
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "msp")
public class MspEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mspId;
	
	@Column(name = "date_of_registration")
	private String dateOfRegistration;
	
	@Column(name = "msp_year")
	private String mspYear;
	
	@Column(name = "season")
	private String season;
	
	@Column(name = "crops")
	private String crops;
	
	@Column(name = "crops_unit")
	private int cropsUnit;
	
	@Column(name = "msp_price")
	private double mspPrice;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String State;
	
	@Column(name = "dist")
	private String dist;
	
	@Column(name = "status")
	private String status;
}
