package com.springboot.rest.h2.springbootrestserviceh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.h2.springbootrestserviceh2.model.Employee;

/**
 * 
 * @author vickey
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
