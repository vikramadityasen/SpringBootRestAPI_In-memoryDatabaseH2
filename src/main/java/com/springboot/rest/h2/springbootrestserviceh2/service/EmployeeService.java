package com.springboot.rest.h2.springbootrestserviceh2.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.rest.h2.springbootrestserviceh2.model.Employee;

/**
 * 
 * @author vickey
 *
 */
public interface EmployeeService {

	public List<Employee> retrieveAllEmployee();

	public Employee retrieveEmployee(Integer empId);

	public void deleteEmployee(Integer empId);

	public Employee createEmployee(Employee employee);

	public ResponseEntity<Employee> updateEmployee(Employee employee, Integer empId);
}
