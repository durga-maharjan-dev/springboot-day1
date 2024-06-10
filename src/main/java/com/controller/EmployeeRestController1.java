package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AuthenticateDTO;
import com.dto.EmployeeDTO;
import com.service.EmployeeService;

@RestController
@RequestMapping("/v1")
public class EmployeeRestController1 {
	
	@Autowired
	private EmployeeService employeeService;
	
	//getting all records.
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDTO>> showAllEmployee() {
		List<EmployeeDTO> employeeDTOList= employeeService.findAll();
		return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
	}
	
	// get record on basis of employeeId
	@GetMapping("/employee/{employeeId}")
	public EmployeeDTO getEmployeeById(@PathVariable int employeeId) {
		EmployeeDTO dto =this.employeeService.findById(employeeId);
		return  dto;
	}
	
	//saving employee
	@PostMapping("/employee")
	public ResponseEntity<String> signup(@RequestBody EmployeeDTO employeeDTO) {
		String message=employeeService.signup(employeeDTO);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	
	
	//authenticate on the basis of email & password
//	@PostMapping("/employee/authenticate")
//	public  EmployeeDTO authenticate(@RequestParam String email, @RequestParam String password) {
//		EmployeeDTO employeeDTO = employeeService.authenticate(email,password);
//		return employeeDTO;
//	}
	
	@PutMapping("/employee")
	public String employeeUpdate(@RequestBody EmployeeDTO employeeDTO) {
		 this.employeeService.employeeUpdate(employeeDTO);
		 return "updated sucessfully.";
	}
	
	@PostMapping("/employee/authenticateWithDTO")
	public EmployeeDTO authenticateWithDTO(@ModelAttribute AuthenticateDTO dto) {
		EmployeeDTO employeeDTO = employeeService.authenticate(dto.getEmail(),dto.getPassword());
		return employeeDTO;
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {
		this.employeeService.deleteEmployee(employeeId);
		return "deleted successfully";
	}
}
