package com.infy.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.employee.dao.EmployeeDAO;
import com.infy.employee.domain.EmployeeEntity;
import com.infy.employee.dto.EmployeeDTO;

/**
 * @author Sandeep_Meduri
 *
 */
@Service
public class EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	/**
	 * @return
	 */
	public List<EmployeeDTO> getEmployees() {
		return employeeDAO.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * @param id
	 * @return
	 */
	public EmployeeDTO getEmployeeById(Long id) {
		Optional<EmployeeEntity> entity =  employeeDAO.findById(id);
		return convertToDTO(entity.get());
	}

	/**
	 * @param employee
	 * @return
	 */
	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		return employeeDAO.save(employee);
	}

	/**
	 * @param employee
	 */
	public void removeEmployee(EmployeeEntity employee) {
		employeeDAO.delete(employee);
	}

	/**
	 * @param employee
	 * @return
	 */
	private EmployeeDTO convertToDTO(EmployeeEntity employee) {
		EmployeeDTO dto = modelMapper.map(employee, EmployeeDTO.class);
		return dto;
	}

}
