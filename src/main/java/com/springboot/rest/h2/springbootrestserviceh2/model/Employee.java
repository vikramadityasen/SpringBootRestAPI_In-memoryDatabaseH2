package com.springboot.rest.h2.springbootrestserviceh2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Integer empId;
	private String name;
	private String dob;
	private String department;
	private String passportNumber;
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dob=" + dob + ", department=" + department
				+ ", passportNumber=" + passportNumber + "]";
	}
	
	public Employee() {
		super();
	}

	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	
	
}
