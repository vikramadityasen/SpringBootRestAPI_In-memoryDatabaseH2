package com.springboot.rest.h2.springbootrestserviceh2.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.rest.h2.springbootrestserviceh2.exception.EmployeeNotFoundException;
import com.springboot.rest.h2.springbootrestserviceh2.model.Employee;
import com.springboot.rest.h2.springbootrestserviceh2.repository.EmployeeRepository;
import com.springboot.rest.h2.springbootrestserviceh2.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> retrieveAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee retrieveEmployee(Integer empId) {
		Optional<Employee> employee = employeeRepository.findById(empId);
		if (!employee.isPresent()) {
			try {
				throw new EmployeeNotFoundException("empId-" + empId);
			} catch (EmployeeNotFoundException employeeNotFoundException) {
				logger.debug("Employee details" + employeeNotFoundException);
			}
		}
		return employee.get();
	}

	@Override
	public void deleteEmployee(Integer empId) {
		employeeRepository.deleteById(empId);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
