package com.orive.GatePass.Dto;

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
public class VechicleEntryPassDto {

    private Long vechicleEntryPassId;
	private Long gatePassNo;
	private Long gateEntryNo;
	private String gateEntryDate;
	private String transporterName;
	private String driverName;
	private String vechicleNo;
	private String divisionName;
	private String deptName;
	private String arrivalTime;
	private String departureTime;
	private String authorisedName;
}
