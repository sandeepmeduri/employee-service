package com.infy.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.employee.domain.EmployeeEntity;

/**
 * @author Sandeep_Meduri
 *
 */
@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Long> {

}
