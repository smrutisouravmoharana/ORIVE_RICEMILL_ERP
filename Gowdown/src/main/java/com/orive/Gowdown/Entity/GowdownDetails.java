package com.orive.Gowdown.Entity;

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
@Table(name = "godown")
public class GowdownDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long godownId;
	
	@Column(name = "godown_name")
	private String godownName;
	
	@OneToMany(targetEntity = GodownProductDetails.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "godown_product_fk",referencedColumnName = "godownId")
	private List<GodownProductDetails> godownProductsDetails=new ArrayList<>();
	
	
}
