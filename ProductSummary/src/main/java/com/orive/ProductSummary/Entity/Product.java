package com.orive.ProductSummary.Entity;


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
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "sale_price")
	private double salePrice;
	
	@Column(name = "cost_price")
	private double costPrice;
	
	@Column(name = "supplier_name")
	private String supplierName;
	
	@Column(name = "sn")
	private String sn;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "unit_name")
	private String unitName;;
	
	@Column(name = "product_details")
	private String productDetails;
	
	@Column(name = "product_vat_percentage")
	private String productVatPercentage;
}
