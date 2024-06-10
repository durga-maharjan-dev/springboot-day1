<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rab3tech | Profile Update</title>
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
<div class="container-wrapper" style="box-sizing:border-box;">
	<div class="container">
		<img src="/img/person-add.png" alt="login-logo">
			<h2>Employee Profile Update</h2>
			<p class="alert-messsage">${message}</p>
			<form action="employeeUpdate" method="post">
				<div class="form-group">
					<label for="employeeId">EmployeeId</label> 
					<input type="text" class="form-control-employeeId" id="employeeId"  value="${employeeDTO.employeeId}" name="employeeId" readonly>
				</div>
				<div class="form-group">
					<label for="firstName">First Name</label> 
					<input type="text" class="form-control" id="firstName" value="${employeeDTO.firstName}" name="firstName" required>
				</div>
				<div class="form-group">
					<label for="lastName">Last Name:</label> 
					<input type="text" class="form-control" id="lastName" value="${employeeDTO.lastName}" name="lastName" required>
				</div>
				<div class="form-group">
					<label for="email">Email:</label> 
					<input type="email" class="form-control" id="email" value="${employeeDTO.email}" name="email" required>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> 
					<input type="text" class="form-control" id="password" value="${employeeDTO.password}" name="password" required>
				</div>
			
				<button type="submit" class="btn-primary">Update Now</button>
			</form>
	</div>
</div>

<footer>
	rab3tech &copy; 2024
</footer>
</body>
</html>