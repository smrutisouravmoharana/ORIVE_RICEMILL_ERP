package com.orive.Sales.Entity;

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
@Table(name = "saleitem")
public class SaleItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long saleItemId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "batch_number")
	private String batchNumber;
	
	@Column(name = "avg_quantity")
	private double avgQuantity;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "rate")
	private double rate;
	
	@Column(name = "discount")
	private double discount;
	
	@Column(name = "discount_value")
	private double discountValue;
	
	@Column(name = "vat")
	private double vat;
	
	@Column(name = "vat_value")
	private double vatValue;
	
	@Column(name = "total")
	private double total;
	
	
	
}
