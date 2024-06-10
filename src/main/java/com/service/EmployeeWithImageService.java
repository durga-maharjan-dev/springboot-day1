package com.service;

import com.dto.EmployeeWithProfileImageDTO;
import com.entity.EmployeeWithProfileImage;

public interface EmployeeWithImageService {

	String save(EmployeeWithProfileImage employeeWithProfileImage);

	EmployeeWithProfileImageDTO authenticate(String email, String password);

}
