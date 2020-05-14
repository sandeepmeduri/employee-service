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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Sandeep_Meduri
 *
 */
@RestController
@Api(value = "EmployeeController, REST APIs that deal with Employee DTO")
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
	@GetMapping(produces = "application/json", path = "/employees")
	@ApiOperation(value = "Fetch all the employees of an organization", response = EmployeeDTO.class, tags = "fetchEmployees")
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetched the employees successfully"),
			@ApiResponse(code = 404, message = "employee details not found") })
	public HttpEntity<List<EmployeeDTO>> getEmployees() {
		List<EmployeeDTO> employees = this.service.getEmployees();
		employees.stream().forEach(p -> this.assembler.toModel(p));
		return ResponseEntity.ok(employees);
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping(produces = "application/json", path = "/employees/{id}")
	@ApiOperation(value = "Fetch an employee by Id", response = EmployeeDTO.class, tags = "fetch Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Fetched the customers successfully"),
			@ApiResponse(code = 404, message = "Customer details not found") })
	public HttpEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
		EmployeeDTO employee = service.getEmployeeById(id);
		this.assembler.toModel(employee);
		return ResponseEntity.ok(employee);
	}

}
