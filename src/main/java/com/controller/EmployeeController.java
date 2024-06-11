package com.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;
import com.service.EmployeeWithImageService;
import com.utils.SortByFirstName;
import com.utils.SortByFirstNameDescending;
import com.utils.SortByLastName;


@Controller 
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@Autowired 
    EmployeeWithImageService employeeWithImageService;
	
	
	@GetMapping({"/employeeLogin","/"})
	public String getLoginPage() {
		return "employee-login";
	}
	
	@PostMapping("/employeeAuthenticate")
	public String authenticate(@RequestParam String email, @RequestParam String password, Model model) {
		System.out.println("Employee Controller: input data: "+ email +" "+ password);
		EmployeeDTO employeeDTO = employeeService.authenticate(email,password);
		if (employeeDTO != null) {
			model.addAttribute("employeeDTO", employeeDTO);
			return "employee-dashboard";
		}else {
			model.addAttribute("message", "Invalid username or password.");
			return "employee-login";
		}
	}
	
	@GetMapping("/employeeProfile/{employeeId}")
	public String employeProfileById(@PathVariable("employeeId") int employeeId, Model model) {
		EmployeeDTO dto = this.employeeService.findById(employeeId);
		model.addAttribute("employeeDTO", dto);
		return "employee-dashboard";
	}
	@GetMapping("/employeeSignup")
	public String getEmployeeSignupPage() {
		System.out.println("getEmployeeSignupPage() invoked.");
		return "employee-signup";
	}
	
	@PostMapping("/employeeSignup")
	public String signup(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
		String message=employeeService.signup(employeeDTO);
		model.addAttribute("message", message);
		return "employee-signup";
	}
	
	@GetMapping("/showAllEmployee")
	public String showAllEmployee(Model model) {
		List<EmployeeDTO> employeeDtos = employeeService.findAll();
		System.out.println("Employee Controller: dtoList: "+ employeeDtos);
		model.addAttribute("dtoList", employeeDtos);
		return "show-all-employee";
	}
	
	@GetMapping("/employeeUpdate")
	public String getUpdatePage(@RequestParam("employeeId") int employeeId, Model model) {
		System.out.println("Employee Controller: employeeId : "+employeeId);
		EmployeeDTO employeeDTO = employeeService.findById(employeeId);
		System.out.println("Employee Controller: employeeDTO : "+ employeeDTO);
		model.addAttribute("employeeDTO", employeeDTO);
		return "employee-profile-update";
	}
	
	
	@PostMapping("/employeeUpdate")
	public String updateEmployee(@ModelAttribute EmployeeDTO employeeDTO,Model model) {
		System.out.println("Employee Controller: post updateEmployee(): "+ employeeDTO);
		EmployeeDTO dto = employeeService.employeeUpdate(employeeDTO);
		model.addAttribute("employeeDTO", dto);
		model.addAttribute("message", "Record Updated Sucssfully!");
		return "employee-dashboard";
//		return "redirect:/showAllEmployee";
		
		
	}
	

	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId, Model model) {
		System.out.println("Employee Controller: deleteEmployee() : "+ employeeId);
		String message = this.employeeService.deleteEmployee(employeeId);
		model.addAttribute("message", message);
		return "redirect:/showAllEmployee";
	}
	
	@GetMapping("/sortByFirstNameOrLastName")
	public String sortByFirstNameOrLastName(@RequestParam("request") String request,Model model) {
		
		if (request.equalsIgnoreCase("firstName")) {
			List<EmployeeDTO> listEmployeeDTO = this.employeeService.findAll();
			Collections.sort(listEmployeeDTO, new SortByFirstName());
			model.addAttribute("dtoList", listEmployeeDTO);
			return "show-all-employee";
		}else {
			List<EmployeeDTO> listDTO = this.employeeService.findAll();
			Collections.sort(listDTO, new SortByLastName());
			model.addAttribute("dtoList", listDTO);
			return "show-all-employee";
			
		}
	}
	
	@GetMapping("/sortByFirstName")
	public String sortByFirstName(Model model) {
		List<EmployeeDTO> employeeDtos = employeeService.findAll();
		Collections.sort(employeeDtos, new SortByFirstName());
		model.addAttribute("dtoList", employeeDtos);
		return "show-all-employee";
	}
	
	@GetMapping("/sortByFirstNameDescending")
	public String sortByFirstNameDescending(Model model) {
		List<EmployeeDTO> employeeDtos = employeeService.findAll();
		Collections.sort(employeeDtos, new SortByFirstNameDescending());
		model.addAttribute("dtoList", employeeDtos);
		return "show-all-employee";
	}
	

	//Hello branch - maharjan100
	//hi this is second commit from maharjan100
	
	
	

	
		
}
