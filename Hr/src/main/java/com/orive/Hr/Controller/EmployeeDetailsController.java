package com.orive.Hr.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orive.Hr.Dto.Employee;
import com.orive.Hr.Service.EmployeeDetailsService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeDetailsController {

	private Logger logger=LoggerFactory.getLogger(EmployeeDetailsController.class);
	
	@Autowired
	private EmployeeDetailsService employeeService;

	@PostMapping(value = "/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        logger.info("Creating a new employee: {}", employee);
        Employee createdEmployee = employeeService.createEmployee(employee);
        logger.info("Created employee: {}", createdEmployee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getemployeeid/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) {
        logger.info("Getting employee by ID: {}", employeeId);
        Employee employee = employeeService.getEmployeeById(employeeId);
        logger.info("Retrieved employee: {}", employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
        logger.info("Updating employee with ID {}: {}", employeeId, updatedEmployee);
        Employee employee = employeeService.updateEmployee(employeeId, updatedEmployee);
        logger.info("Updated employee: {}", employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        logger.info("Deleting employee with ID: {}", employeeId);
        employeeService.deleteEmployee(employeeId);
        logger.info("Employee deleted with ID: {}", employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        logger.info("Getting all employees");
        List<Employee> employees = employeeService.getAllEmployees();
        logger.info("Retrieved {} employees", employees.size());
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
