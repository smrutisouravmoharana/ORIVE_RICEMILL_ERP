package com.orive.Stock.Entity;

import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class Purchase {

    private Long purchaseId;
	
	private String supplierName;
	
	private Long stockId;
	
	private String chalanNumber;
	
	private LocalDate purchaseDate;
	
	private String details;
	
	private double total;
	
	private double purchaseDiscount;
	
	private double totalDiscount;
	
	private double totalVat;
	
	private double grandTotal;
	
	private double paidAmount;
	
	private double dueAmount;
	
	private String paymentType;
	
	private List<PurchaseProduct> godownProducts; 
}
