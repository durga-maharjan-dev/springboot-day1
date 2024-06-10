<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rab3tech | Login</title>
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
		<li><a href="employeeSignup">Employee Signup</a></li>
		<li><a href="#">Home</a></li>
	</ul>
</header>

<div class="container-wrapper">
	<div class="container">
		<img src="img/authenticate.png" alt="login-logo">
		<h2>Employee Login</h2>
		<p class="alert-message">${message}</p>
		<form action="employeeAuthenticateWithImage" method="post">
			<div class="form-group">
				<label for="email">Email:</label> 
				<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> 
				<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
			</div>
			<div class=" form-check">
				<label class="form-check-label"> 
					<input class="form-check-input" type="checkbox" name="remember">Remember me
				</label>
			</div>
			<button type="submit" class="btn-primary">Login</button>
		</form>
		<div class="info-message">
			<p>No Account,<p>
			<p>Click <a href="employeeSignup">here</a> to signup<p>
		</div>
	</div>
</div>

<footer>
	rab3tech &copy; 2024
</footer>

</body>
</html>