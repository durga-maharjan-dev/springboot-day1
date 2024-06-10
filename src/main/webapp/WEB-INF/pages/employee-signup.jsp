<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rab3tech | Employee Signup</title>
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
		<li><a href="employeeLogin">Login</a></li>
		<li><a href="employeeSignup">Employee Signup</a></li>
		
	</ul>
</header>

<div class="container-wrapper">
	<div class="container">
		<img src="/img/person-add.png" alt="login-logo">
		<h2>Employee Signup</h2>
		<p class="alert-messsage">${message}</p>
		<form action="employeeSignup" method="post">
			<div class="form-group">
				<label for="firstName">First Name</label> 
				<input type="text" class="form-control" id="firstName" placeholder="Enter First Name" name="firstName" required>
			</div>
			<div class="form-group">
				<label for="lastName">Last Name:</label> 
				<input type="text" class="form-control" id="lastName" placeholder="Enter Last Name" name="lastName" required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> 
				<input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
			</div>
		
			<button type="submit" class="btn-primary">Sign Up</button>
		</form>
		
	</div>
</div>

<footer>
	rab3tech &copy; 2024
</footer>

</body>
</html>