package com.springboot.rest.h2.springbootrestserviceh2.restcontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.rest.h2.springbootrestserviceh2.model.Employee;
import com.springboot.rest.h2.springbootrestserviceh2.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployee")
	public List<Employee> retrieveAllEmployee() {
		return employeeService.retrieveAllEmployee();
	}

	@GetMapping("/getEmployee/{empId}")
	public Employee retrieveEmployee(@PathVariable Integer empId) {
		return employeeService.retrieveEmployee(empId);
	}

	@DeleteMapping("/deleteEmployee/{empId}")
	public void deleteEmployee(@PathVariable Integer empId) {
		employeeService.deleteEmployee(empId);
	}

	@PostMapping("/createEmployee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.createEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{empId}")
				.buildAndExpand(savedEmployee.getEmpId()).toUri();

		return ResponseEntity.created(location).build();
	}
}
