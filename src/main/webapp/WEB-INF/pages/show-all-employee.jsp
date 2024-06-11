<%@page import="com.dto.EmployeeDTO"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rab3tech | All SIGNUP</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

<header>
	<div class="header-title">
		<h1>Rab3tech</h1>
	</div>
	<ul class="header-navbar">
		<li><a href="#">Profile</a></li>
		<li><a href="employeeLogin">Sign Out</a></li>
	</ul>
</header>

<div class="container-wrapper">
	<div class="container container-employee-list">
	<h2>All Employee</h2>
	${message}
	<table>
		<thead>
			<tr>
				<th>Employee Id</th>
				<th>First Name <a href="sortByFirstName" class="down-arrow">↓</a>  <a href="sortByFirstNameDescending" class="down-arrow">↑</a></th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Password</th>
				<th colspan="2">Action</th>		
			</tr>
		</thead>
	
			<c:forEach items="${dtoList}" var="dto">
			<tr>
				<td>${dto.employeeId}</td>
				<td>${dto.firstName}</td>
				<td>${dto.lastName}</td>
				<td>${dto.email}</td>
				<td>${dto.password}</td>
				<td><a href="employeeUpdate?employeeId=${dto.employeeId}"><button type="button" class="btn-warning" >Update</button></a></td>
				<td><a href="deleteEmployee?employeeId=${dto.employeeId}"><button type="button" class="btn-danger">Delete</button></a></td>
			</tr>
			</c:forEach>
	</table>


	<div class="sorting-mechanism">
		 Sort By
		<form action="/sortByFirstNameOrLastName">
			<input type="checkbox"  id="request" name="request" value="firstName">
  			<label for="firstName">First Name</label>
  			<input type="checkbox" id="request" name="request" value="lastName">
  			<label for="lastName"> Last Name</label>
		   <input type="submit" value="Sort" class="btn-update">
		</form>

		</div>

	</div>
	
	
</div>
</body>
</html>