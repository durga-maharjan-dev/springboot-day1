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
import com.exception.EmployeeIdNegativeException;
import com.exception.EmployeeIdNotFoundException;
import com.exception.EmployeeNotFoundException;
import com.service.EmployeeService;

@RestController
@RequestMapping("/v3")
public class EmployeeRestController3 {
	
	@Autowired
	private EmployeeService employeeService;
	
	//getting all records.
	@GetMapping("/employee")
	public List<EmployeeDTO> showAllEmployee() {
		List<EmployeeDTO> employeeDTOList= employeeService.findAll();
		return employeeDTOList;
	}
	
	// get record on basis of employeeId
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int employeeId) {
		EmployeeDTO dto =this.employeeService.findById(employeeId);
		if (dto != null) {
			return  new ResponseEntity<>(dto, HttpStatus.OK);
		}else {
			
			
//			return new ResponseEntity<>(applicationStatus,HttpStatus.NOT_FOUND);
			throw new EmployeeNotFoundException("Employee does not exist.");
		}
		
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
	public ResponseEntity<?> employeeUpdate(@RequestBody EmployeeDTO employeeDTO) {
		if (employeeDTO.getEmployeeId() <= 0) {
			throw new EmployeeIdNotFoundException("Employee Not Found.");
		}
		 this.employeeService.employeeUpdate(employeeDTO);
		 return new ResponseEntity<>("a record updated successfully.", HttpStatus.CREATED);
//		 return "updated sucessfully.";
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<String>  deleteEmployeeById(@PathVariable int employeeId) {
		
		if (employeeId <= 0 ) {
			throw new EmployeeIdNegativeException("Employee ID cannot be zero or nagative");
		}
		
		try {
			this.employeeService.deleteEmployee(employeeId);
			return new ResponseEntity<>("a record deleted successfully.",HttpStatus.OK);
		}catch(Exception e) {
			throw new EmployeeIdNotFoundException("Employee Id Not Exists.");
		}
		
//		return "deleted successfully";
	}
	
	//pending
	@PostMapping("/employee/authenticateWithDTO")
	public EmployeeDTO authenticateWithDTO(@ModelAttribute AuthenticateDTO dto) {
		EmployeeDTO employeeDTO = employeeService.authenticate(dto.getEmail(),dto.getPassword());
		return employeeDTO;
	}
}
