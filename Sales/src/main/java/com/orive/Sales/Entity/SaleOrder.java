package com.orive.Sales.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
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
@Table(name = "saleorder")
public class SaleOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long saleId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "sale_date")
	private Date saleDate;
	
	@Column(name = "sale_discount")
	private double saleDiscount;
	
	@Column(name = "total_discount")
	private double totalDiscount;
	
	@Column(name = "total_vat")
	private double totalVat;
	
	@Column(name = "shipping_cost")
	private double shippingCost;
	
	@Column(name = "grand_total")
	private double grandTotal;
	
	@Column(name = "previous")
	private double previous;
	
	@Column(name = "net_total")
	private double netTotal;
	
	@Column(name = "paid_amount")
	private double paidAmount;
	
	@Column(name = "due")
	private double due;
	
	@Column(name = "'change'")
	private double change;
	
	@Column(name = "payment_type")
	private String paymentType;
	
	@OneToMany(targetEntity = SaleItem.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "sale_item_fk",referencedColumnName = "saleId")
	private List<SaleItem> saleItems=new ArrayList<>();
}
