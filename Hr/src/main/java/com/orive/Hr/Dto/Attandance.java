package com.orive.Hr.Dto;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
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
public class Attandance {

    private Long attandanceId;
	
	private String employeeName;

	private Date presentDate;
	
	private String login;
	
	private String logout;
	
	private double workingHour;
}
