package com.dto;

import java.util.Arrays;

public class EmployeeWithProfileImageDTO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private byte[] profileImage;
	public EmployeeWithProfileImageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeWithProfileImageDTO(int employeeId, String firstName, String lastName, String email, String password,
			byte[] profileImage) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.profileImage = profileImage;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	@Override
	public String toString() {
		return "EmployeeWithProfileImageDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + ", profileImage="
				+ Arrays.toString(profileImage) + "]";
	}
	
	
	
	

}
