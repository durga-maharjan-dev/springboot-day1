package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDao;
import com.dto.EmployeeDTO;
import com.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;

	@Override
	public String signup(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDTO, employee);
		Employee dbEmployee =employeeDao.save(employee);
		if (dbEmployee !=null) {
			return "Signup Sucess.";
		}else {
			return "Signup Invalid.";
		}

	}

	@Override
	public EmployeeDTO authenticate(String email, String password) {
		Optional<Employee> optional = employeeDao.findByEmailAndPassword(email,password);
		
		EmployeeDTO employeeDTO = null;
		if (optional.isPresent()) {
			employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(optional.get(), employeeDTO);
			System.out.println("Employee Service: employeeDTO: "+ employeeDTO);
			return employeeDTO;
		}
		System.out.println("Employee Service: employeeDTO: "+ employeeDTO);
		return employeeDTO;
	}

	@Override
	public EmployeeDTO employeeUpdate(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDTO, employee);
		Employee dbEmployee =employeeDao.save(employee);
		
		EmployeeDTO dto = new EmployeeDTO();
		BeanUtils.copyProperties(dbEmployee, dto);
		
		return dto;
	}

	@Override
	public List<EmployeeDTO> findAll() {
		List<Employee> employeeList=employeeDao.findAll();
		
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		
		for(Employee employee:employeeList) {
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(employee, dto);
			employeeDTOList.add(dto);
		}
		System.out.println("Employee Service: employeeDTOs: "+ employeeDTOList);
		return employeeDTOList;
	}

	@Override
	public EmployeeDTO findById(int employeeId) {
	 Optional<Employee> optional = employeeDao.findById(employeeId);
	 EmployeeDTO employeeDTO = null;
	 	if(optional.isPresent()) {
	 		 employeeDTO = new EmployeeDTO();
	 		BeanUtils.copyProperties(optional.get(), employeeDTO);
	 		return employeeDTO;
	 	}
	 	return employeeDTO;
	
	}

	@Override
	public String deleteEmployee(int employeeId) {
		this.employeeDao.deleteById(employeeId);
		return "Record deleted successfully.";
	}

}