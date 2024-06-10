package com.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeWithImageDao;
import com.dto.EmployeeWithProfileImageDTO;
import com.entity.EmployeeWithProfileImage;

@Service
@Transactional
public class EmployeeWithImageServiceImpl implements EmployeeWithImageService {
	
	@Autowired
	private EmployeeWithImageDao employeeWithImageDao;

	@Override
	public String save(EmployeeWithProfileImage employeeWithProfileImage) {
		this.employeeWithImageDao.save(employeeWithProfileImage);
		return "profile saved successfully.";
	}

	@Override
	public EmployeeWithProfileImageDTO authenticate(String email, String password) {
		EmployeeWithProfileImage employeeWithProfileImage =this.employeeWithImageDao.findByEmailAndPassword(email,password);
		
		EmployeeWithProfileImageDTO dto = null;
		
		if (employeeWithProfileImage!=null) {
			dto = new EmployeeWithProfileImageDTO();
			BeanUtils.copyProperties(employeeWithProfileImage, dto);
			return dto;
		}
		
		return dto;
	}

}
