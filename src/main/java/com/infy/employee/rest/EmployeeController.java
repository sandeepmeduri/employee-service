package com.infy.employee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employee.assembler.EmployeeAssembler;
import com.infy.employee.dto.EmployeeDTO;
import com.infy.employee.service.EmployeeService;

/**
 * @author Sandeep_Meduri
 *
 */
@RestController
public class EmployeeController {

	private EmployeeService service;

	@Autowired
	private EmployeeAssembler assembler;

	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	/**
	 * @return
	 */
	@GetMapping("/employees")
	public HttpEntity<List<EmployeeDTO>> getEmployees() {
		List<EmployeeDTO> employees = this.service.getEmployees();
		employees.stream().forEach(p -> this.assembler.toModel(p));
		return ResponseEntity.ok(employees);
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/employees/{id}")
	public HttpEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
		EmployeeDTO employee = service.getEmployeeById(id);
		this.assembler.toModel(employee);
		return ResponseEntity.ok(employee);
	}

}
