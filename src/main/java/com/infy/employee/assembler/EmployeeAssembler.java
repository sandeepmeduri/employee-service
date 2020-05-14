package com.infy.employee.assembler;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.infy.employee.dto.EmployeeDTO;
import com.infy.employee.rest.EmployeeController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author Sandeep_Meduri
 *
 */
@Component
public class EmployeeAssembler extends RepresentationModelAssemblerSupport<EmployeeDTO, EmployeeDTO> {

	/**
	 * 
	 */
	public EmployeeAssembler() {
		super(EmployeeController.class, EmployeeDTO.class);
	}

	/**
	 *
	 */
	@Override
	public EmployeeDTO toModel(EmployeeDTO entity) {
		entity.add(linkTo(methodOn(EmployeeController.class)
				.getEmployeeById(entity.getId()))
				.withSelfRel());
		return entity;
	}
}