package com.orive.Hr.Entity;


import java.util.Date;

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
@Table(name = "attandancedetails")
public class AttandanceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attandanceId;
	
	@Column(name = "employee_name")
	private String employeeName;
	
	@Column(name = "present_date")
	private Date presentDate;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "logout")
	private String logout;
	
	@Column(name = "working_hour")
	private double workingHour;
}
