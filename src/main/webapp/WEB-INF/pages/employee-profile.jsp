<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rab3tech | Employee Profile</title>
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
		<li><a href="updateEmployee/${employeeDTO.employeeId}">Profile</a></li>
		<li><a href="employeeLogin">Sign Out</a></li>
	</ul>
</header>

<div class="container-wrapper">
	<div class="container">
		<img src="/img/edit.png" alt="login-logo">
		<h2>Employee Profile</h2>
		<p class="alert-message">${message}</p>
		<form action="/employeeUpdate" method="post">
			<div class="form-group">
				<label for="employeeId" >Employee Id</label> 
				<input type="number" class="form-control" id="employeeId" placeholder="${employeeDTO.employeeId}" value="${employeeDTO.employeeId}" name="employeeId" readonly>
			</div>
		<div class="form-group">
				<label for="firstName">First Name</label> 
				<input type="text" class="form-control" id="firstName" placeholder="${employeeDTO.firstName}" name="firstName" required>
			</div>
			<div class="form-group">
				<label for="lastName">Last Name:</label> 
				<input type="text" class="form-control" id="lastName" placeholder="${employeeDTO.lastName}" name="lastName" required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="email" class="form-control" id="email" placeholder="${employeeDTO.email}" name="email">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> 
				<input type="password" class="form-control" id="password" placeholder="${employeeDTO.password}" name="password">
			</div>
			
			<button type="submit" class="btn-update">UPDATE</button>
		</form>

	</div>
</div>

<footer>
	<p>rab3tech &copy; 2024</p>
</footer>

</body>
</html>