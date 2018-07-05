package com.springboot.rest.h2.springbootrestserviceh2.service;

import java.util.List;

import com.springboot.rest.h2.springbootrestserviceh2.model.Employee;

public interface EmployeeService {

	public List<Employee> retrieveAllEmployee();

	public Employee retrieveEmployee(Integer empId);

	public void deleteEmployee(Integer empId);

	public Employee createEmployee(Employee employee);
}
