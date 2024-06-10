<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rab3tech | Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<header>
	<div class="header-title">
		<h1>Rab3tech</h1>
	</div>
	<ul class="header-navbar">
		<li><a href="employeeProfile/${employeeDTO.employeeId}">Profile</a></li>
		<li><a href="employeeLogin">Sign Out</a></li>
	</ul>
</header>

<div class="container-wrapper">
	<div class="container">
		<img src="/img/profile.png" alt="profile-logo">
		<h2>Employee Dashboard</h2>
	
			<div class="form-group">
				<label for="employeeId">Employee Id: ${employeeDTO.employeeId}</label> 
				
			</div>
			<div class="form-group">
				<label for="firstName">First Name: ${employeeDTO.firstName}</label> 
			</div>
			<div class="form-group">
				<label for="lastName">Last Name: ${employeeDTO.lastName}</label> 
				
			</div>
			<div class="form-group">
				<label for="email">Email: ${employeeDTO.email}</label> 
				
			</div>
			<div class="form-group">
				<label for="password">Password: ${employeeDTO.password}</label> 
			</div>
			
			<div>
				<a href="employeeUpdate?employeeId=${employeeDTO.employeeId}"><button class="btn-update">UPDATE</button></a>
			</div>
	</div>
	
	<div>
		<p style="color:#00f;text-align:center;font-size:2rem;">Click Below</p>
		<a href="showAllEmployee"><button type="button" class="btn-showall">SEE SIGNUP ALL EMPLOYEE</button></a>
	</div>
</div>

<footer>
	rab3tech &copy; 2024
</footer>

</body>
</html>