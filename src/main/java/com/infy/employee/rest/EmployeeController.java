package com.infy.employee.rest;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.employee.assembler.EmployeeAssembler;
import com.infy.employee.domain.EmployeeEntity;
import com.infy.employee.dto.CurrencyExchangeDTO;
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
@RequestMapping("/api")
@Api(value = "EmployeeController, REST APIs that deal with Employee DTO")
public class EmployeeController {

	private EmployeeService service;

	@Autowired
	private EmployeeAssembler assembler;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private RestTemplate restTemplate;

	private final String currencUrl = "http://18.191.179.132:8881/api/currencyrate";

	private final String from = "from";

	private final String to = "to";

	private final String USD = "USD";

	private final String INR = "INR";

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
		employees.stream().forEach(p -> {
			this.assembler.toModel(p);
			getCurrencyExchange(p, USD, INR);
		});
		return ResponseEntity.ok(employees);
	}

	/**
	 * @param id
	 * @return
	 */
	@GetMapping(produces = "application/json", path = "/employees/{id}")
	@ApiOperation(value = "Fetch an employee by Id", response = EmployeeDTO.class, tags = "fetch Employee by Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Fetched the employee successfully"),
			@ApiResponse(code = 404, message = "employee details not found") })
	public HttpEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
		EmployeeDTO employee = service.getEmployeeById(id);
		this.assembler.toModel(employee);
		getCurrencyExchange(employee, USD, INR);
		return ResponseEntity.ok(employee);
	}

	/**
	 * @param entity
	 * @return
	 */
	@PostMapping(consumes = "application/json", produces = "application/json", path = "/employee")
	@ApiOperation(value = "add an employee", response = EmployeeDTO.class, tags = "add Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "added employee successfully"),
			@ApiResponse(code = 404, message = "employee details not found") })
	public HttpEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeEntity entity) {
		if (null == service.getEmployeeById(entity.getId())) {
			EmployeeDTO dto = service.addEmployee(entity);
			this.assembler.toModel(dto);
			getCurrencyExchange(dto, USD, INR);
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

	/**
	 * @param entity
	 * @return
	 */
	@PutMapping(consumes = "application/json", produces = "application/json", path = "/employee")
	@ApiOperation(value = "Update an employee", response = EmployeeDTO.class, tags = "update Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "updated employee successfully"),
			@ApiResponse(code = 404, message = "employee details not found") })
	public HttpEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeEntity entity) {
		if (!(null == service.getEmployeeById(entity.getId()))) {
			EmployeeDTO dto = service.addEmployee(entity);
			this.assembler.toModel(dto);
			getCurrencyExchange(dto, USD, INR);
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping(produces = "application/json", path = "/employees/{id}")
	@ApiOperation(value = "Remove an employee", response = EmployeeDTO.class, tags = "remove Employee")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "removed employee successfully"),
			@ApiResponse(code = 404, message = "employee details not found") })
	public HttpEntity<EmployeeDTO> removeEmployee(@PathVariable Long id) {
		if (!(null == service.getEmployeeById(id))) {
			EmployeeDTO dto = service.getEmployeeById(id);
			service.removeEmployee(mapper.map(dto, EmployeeEntity.class));
			getCurrencyExchange(dto, USD, INR);
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

	private void getCurrencyExchange(EmployeeDTO employee, String sourceCurrency, String destCurrency) {
		String restUrl = currencUrl + "/" + from + "/" + sourceCurrency + "/" + to + "/"+destCurrency;
		try {
			ResponseEntity<CurrencyExchangeDTO> dto = restTemplate.getForEntity(restUrl, CurrencyExchangeDTO.class);
			employee.setSalaryInInr(employee.getSalary() * dto.getBody().getConversion());
		}catch(Exception ex){
			
		}
	}

}
