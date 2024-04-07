package com.orive.InventoryManufacturingJournal.Entity;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "manufactureproduct")
public class ManufactureProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long manufactureproductId;
	
	@Column(name = "number_of_the_products")
	private Long numberOfTheProducts;
	
	@Column(name = "percentage_of_cost_allocation")
	private double percentageOfCostAllocation;
	
	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "name_of_bom")
	private String nameOfBom;
	
	@Column(name = "batch_name")
	private String batchName;
	
	@Column(name = "mfg_date")
	private Date mfgDate;
	
	@OneToMany(targetEntity = Components.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "component_manufacture_product_fk",referencedColumnName = "manufactureproductId")
	private List<Components> components;
	
	@OneToMany(targetEntity = CoProducts.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "coproduct_manufacture_product_fk",referencedColumnName = "manufactureproductId")
	private List<CoProducts> coProducts;
	
	@Column(name = "cost_of_components")
	private double costOfComponents;
	
	@Column(name = "total_aditional_cost")
	private double totalAditionalCost;
	
	@Column(name = "effective_cost")
	private double effectiveCost;
	
	@Column(name = "allocation_to_primary_item")
	private double allocationToPrimaryItem;
	
	@Column(name = "effective_rate_of_primary_item")
	private double effectiveRateOfPrimaryItem;
}
