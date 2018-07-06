package com.springboot.rest.h2.springbootrestserviceh2.restcontroller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.h2.springbootrestserviceh2.model.Employee;
import com.springboot.rest.h2.springbootrestserviceh2.service.EmployeeService;

/**
 * 
 * @author vickey
 *
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployee")
	public List<Employee> retrieveAllEmployee() {
		return employeeService.retrieveAllEmployee();
	}

	@GetMapping("/getEmployee/{empId}")
	public Employee retrieveEmployee(@PathVariable Integer empId) {
		logger.debug("Details of employee having employee Id is- {}", empId);
		return employeeService.retrieveEmployee(empId);
	}

	@DeleteMapping("/deleteEmployee/{empId}")
	public void deleteEmployee(@PathVariable Integer empId) {
		logger.debug("Deleted employee having employee Id- {}", empId);
		employeeService.deleteEmployee(empId);
	}

	@PostMapping("/createEmployee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.createEmployee(employee);
		logger.debug("Details of newly created employee- {}", savedEmployee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{empId}")
				.buildAndExpand(savedEmployee.getEmpId()).toUri();
		logger.debug("URI- {}", location);
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/updateEmployee/{empId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable Integer empId) {
		logger.debug("Update employee details- {}", employee);
		return employeeService.updateEmployee(employee, empId);
	}
}
