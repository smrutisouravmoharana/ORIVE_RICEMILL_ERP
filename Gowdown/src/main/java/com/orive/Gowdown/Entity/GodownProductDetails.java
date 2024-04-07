package com.orive.Gowdown.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "godownproduct")
public class GodownProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "purchase_date")
	private Date purchaseDate;
	
	@Column(name = "product_net_quantity")
	private double productNetQuantity;
	
	@Column(name = "pocket_size")
    private double pocketSize;
	
	@Column(name = "no_of_product_pocket")
	private double noOfProductPocket;
	
	@Column(name = "net_quantity")
	private double netQuantity;
	
	@ManyToOne
	private GowdownDetails gowdownDetails;
}
