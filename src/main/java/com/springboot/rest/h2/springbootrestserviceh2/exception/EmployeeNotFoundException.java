package com.springboot.rest.h2.springbootrestserviceh2.exception;

/**
 * 
 * @author vickey
 *
 */
@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException(String string) {
		super(string);
	}
}
