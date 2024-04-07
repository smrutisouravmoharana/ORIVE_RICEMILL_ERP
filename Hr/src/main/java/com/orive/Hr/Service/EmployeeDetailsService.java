package com.orive.Hr.Service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Hr.Dto.Employee;
import com.orive.Hr.Entity.EmployeeDetails;
import com.orive.Hr.Repository.EmployeeDetailsRepository;

@Service
public class EmployeeDetailsService {

	private Logger logger=LoggerFactory.getLogger(EmployeeDetailsService.class);
	
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create an Employee
    public Employee createEmployee(Employee employee) {
        logger.info("Creating a new employee: {}", employee);
        
        EmployeeDetails employeeDetails = modelMapper.map(employee, EmployeeDetails.class);
        employeeDetails = employeeDetailsRepository.save(employeeDetails);

        logger.info("Employee created: {}", employeeDetails);

        return modelMapper.map(employeeDetails, Employee.class);
    }

    // Read an Employee by ID
    public Employee getEmployeeById(Long employeeId) {
        logger.info("Getting employee by ID: {}", employeeId);
        
        EmployeeDetails employeeDetails = employeeDetailsRepository.findById(employeeId)
                .orElseThrow(() -> {
                    logger.error("Employee not found for ID: {}", employeeId);
                    return new RuntimeException("Employee not found");
                });

        logger.info("Retrieved employee: {}", employeeDetails);

        return modelMapper.map(employeeDetails, Employee.class);
    }

    // Update an Employee
    public Employee updateEmployee(Long employeeId, Employee updatedEmployee) {
        logger.info("Updating employee with ID {}: {}", employeeId, updatedEmployee);
        
        EmployeeDetails employeeDetails = employeeDetailsRepository.findById(employeeId)
                .orElseThrow(() -> {
                    logger.error("Employee not found for ID: {}", employeeId);
                    return new RuntimeException("Employee not found");
                });

        modelMapper.map(updatedEmployee, employeeDetails);

        employeeDetails = employeeDetailsRepository.save(employeeDetails);

        logger.info("Updated employee: {}", employeeDetails);

        return modelMapper.map(employeeDetails, Employee.class);
    }

    // Delete an Employee
    public void deleteEmployee(Long employeeId) {
        logger.info("Deleting employee with ID: {}", employeeId);

        employeeDetailsRepository.deleteById(employeeId);
        
        logger.info("Employee deleted with ID: {}", employeeId);
    }

    // Get all Employees
    public List<Employee> getAllEmployees() {
        logger.info("Getting all employees");

        List<EmployeeDetails> employeeDetailsList = employeeDetailsRepository.findAll();

        logger.info("Retrieved {} employees", employeeDetailsList.size());

        return employeeDetailsList.stream()
                .map(employeeDetails -> modelMapper.map(employeeDetails, Employee.class))
                .collect(Collectors.toList());
    }
}
