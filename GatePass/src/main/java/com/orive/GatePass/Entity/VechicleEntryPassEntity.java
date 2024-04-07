package com.orive.GatePass.Entity;

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
@Table(name = "vechicle_entry_pass")
public class VechicleEntryPassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vechicleEntryPassId;
	
	@Column(name = "gate_pass_no")
	private Long gatePassNo;
	
	@Column(name = "gate_entry_no")
	private Long gateEntryNo;
	
	@Column(name = "gate_entry_date")
	private String gateEntryDate;
	
	@Column(name = "transporter_name")
	private String transporterName;
	
	@Column(name = "driver_name")
	private String driverName;
	
	@Column(name = "vechicle_no")
	private String vechicleNo;
	
	@Column(name = "division_name")
	private String divisionName;
	
	@Column(name = "dept_name")
	private String deptName;
	
	@Column(name = "arrival_time")
	private String arrivalTime;
	
	@Column(name = "departure_time")
	private String departureTime;
	
	@Column(name = "authorised_name")
	private String authorisedName;
}
