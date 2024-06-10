package com.service;

import java.util.List;

import com.dto.EmployeeDTO;

public interface EmployeeService {

	String signup(EmployeeDTO employeeDTO);

	EmployeeDTO authenticate(String email, String password);

	EmployeeDTO employeeUpdate(EmployeeDTO employeeDTO);

	List<EmployeeDTO> findAll();

	EmployeeDTO findById(int employeeId);

	String deleteEmployee(int employeeId);

}
