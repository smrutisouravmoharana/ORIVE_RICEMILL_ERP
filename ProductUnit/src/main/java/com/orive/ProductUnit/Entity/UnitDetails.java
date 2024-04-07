package com.orive.ProductUnit.Entity;

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
@Table(name = "unit_details")
public class UnitDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long unitId;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "status")
	private String status;
	
}
