package com.orive.Stock.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_type")
	private String productType;
	
	@Column(name = "sale_price")
	private double salePrice;
	
	@Column(name = "purchase_price")
	private double purchasePrice;
	
	@Column(name = "in_quantity")
	private double inQuantity;
	
	@Column(name = "date")
	private LocalDate date;
	
	@Column(name = "stock")
	private double stock;
	
	
	
	@Transient
	private List<Purchase> purchases=new ArrayList<>();
}
