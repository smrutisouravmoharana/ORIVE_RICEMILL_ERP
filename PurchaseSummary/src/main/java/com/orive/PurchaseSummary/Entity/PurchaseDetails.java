package com.orive.PurchaseSummary.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "purchase")
public class PurchaseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseId;
	
	@Column(name = "supplier_name")
	private String supplierName;
	
	@Column(name = "chalan_number")
	private String chalanNumber;
	
	@Column(name = "stock_id")
	private Long stockId;
	
	@Column(name = "purchase_date")
	private LocalDate purchaseDate;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "total")
	private double total;
	
	@Column(name = "purchase_discount")
	private double purchaseDiscount;
	
	@Column(name = "total_discount")
	private double totalDiscount;
	
	@Column(name = "total_vat")
	private double totalVat;
	
	@Column(name = "grand_total")
	private double grandTotal;
	
	@Column(name = "paid_amount")
	private double paidAmount;
	
	@Column(name = "due_amount")
	private double dueAmount;
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@OneToMany(targetEntity = PurchaseProductDetails.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "godown_product_fk",referencedColumnName = "purchaseId")
	private List<PurchaseProductDetails> godownProductsDetails=new ArrayList<>();
	
	
}
