package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.EmployeeWithProfileImage;

@Repository
public interface EmployeeWithImageDao extends JpaRepository<EmployeeWithProfileImage, Integer>{

	EmployeeWithProfileImage findByEmailAndPassword(String email, String password);

}
