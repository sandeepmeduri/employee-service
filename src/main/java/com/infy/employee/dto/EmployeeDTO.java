package com.infy.employee.dto;

import org.springframework.hateoas.RepresentationModel;

/**
 * @author Sandeep_Meduri
 *
 */
public class EmployeeDTO extends RepresentationModel<EmployeeDTO> {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private double salary;

	private double salaryInInr = Double.NaN;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Long id, String firstName, String lastName, String email, double salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalaryInInr() {
		return salaryInInr;
	}

	public void setSalaryInInr(double salaryInInr) {
		this.salaryInInr = salaryInInr;
	}

}
