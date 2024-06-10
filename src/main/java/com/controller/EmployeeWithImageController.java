package com.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dto.AuthenticateDTO;
import com.dto.EmployeeWithProfileImageDTO;
import com.entity.EmployeeWithProfileImage;
import com.service.EmployeeWithImageService;

@Controller
public class EmployeeWithImageController {
	
	
	@Autowired EmployeeWithImageService employeeWithImageService;
	
	@GetMapping("/signup-with-profile-image")
	public String getSigupWithProfileImage() {
		return "employee-signup-with-profile-image";
	}
	
	@PostMapping("/employeeSignupWithProfileImage")
	public String employeeSignupWithProfileImage(
			@RequestParam String firstName,
			@RequestParam String lastName,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam MultipartFile profileImage, 
			Model model ) throws IOException {

		String message = this.employeeWithImageService.save(
				new EmployeeWithProfileImage(firstName, lastName, email, password, profileImage.getBytes())
				);
		
		model.addAttribute("message", message);
		return "employee-signup-with-profile-image";
	}
	
	@GetMapping("/employee-login-with-image")
	public String employeeLoginWithImage() {
		return "employee-login-with-image";
	}
	
	@PostMapping("/employeeAuthenticateWithImage")
	public String employeeAuthenticateWithImage(@ModelAttribute AuthenticateDTO dto, Model model) {
		EmployeeWithProfileImageDTO dbDTO = this.employeeWithImageService.authenticate(dto.getEmail(),dto.getPassword());
		
		String profileImage = Base64.getEncoder().encodeToString(dbDTO.getProfileImage());
		model.addAttribute("profileImage", profileImage);
		model.addAttribute("employeeDTO", dbDTO);
		return "employee-dashboard-with-image";
	}
	


}
