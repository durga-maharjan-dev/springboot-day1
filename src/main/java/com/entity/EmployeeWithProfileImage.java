package com.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="employee_profile_image_tbl")
public class EmployeeWithProfileImage {
	@Id //making PK
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int employeeId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Lob
	@Column(name="profile_image",columnDefinition="LONGBLOB")
	private byte[] profileImage;
	
	
	public EmployeeWithProfileImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeWithProfileImage( String firstName, String lastName, String email, String password,
			byte[] profileImage) {
		super();
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
		return "EmployeeWithProfileImage [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + ", profileImage="
				+ Arrays.toString(profileImage) + "]";
	}
	
	
	
}
