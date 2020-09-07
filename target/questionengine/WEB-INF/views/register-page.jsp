
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="utf-8">
<head>
	<title>Question Engine - Register</title>
	<link rel=icon href="resources/images/fav.png">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/css/Rss.css">
	<link rel="stylesheet" type="text/css" href="resources/css/register.css">
	<link
		href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap"
		rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<script src="resources/js/jquery-3.4.1.min.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="login-content">
			<form:form action="addUser" modelAttribute="userBuilder" method="post" onsubmit="return validate();">

				<!-- First Name -->
				<div class="input-div one">
					<div class="i">
						<i class="fas fa-user"></i>
					</div>
					<div class="div1">
						<h5>First Name</h5>
						<form:input id="fn" path="firstName" class="input" onblur="onblurFunction(id);" onkeyup="onkeyupFunction(id);"/>
					</div>
					<span class="error-span error">Please enter your first name.</span>
					<span class="error-span error">Name must be 2 characters at least.</span>
				</div>

				<!-- Last Name -->
				<div class="input-div one">
					<div class="i">
						<i class="fas fa-user"></i>
					</div>
					<div class="div">
						<h5>Last Name</h5>
						<form:input id="ln" path="lastName" class="input" onblur="onblurFunction(id);" onkeyup="onkeyupFunction(id);"/>
					</div>
					<span class="error-span error">Please enter your last name.</span>
					<span class="error-span error">Name must be 2 characters at least.</span>
				</div>
				
				
				<!-- Email -->
				<div class="input-div one">
					<div class="i">
						<i class="fas fa-envelope"></i>
					</div>
					<div class="div">
						<h5>E-mail</h5>
						<form:input id="email" path="email" class="input" onblur="onblurFunction(id);" onkeyup="onkeyupFunction(id);"/>
					</div>
					<span class="error-span error">Please enter your email address.</span>
                	<span class="error-span error">Please enter a valid email address.</span>
				</div>
				
				
				<!-- Password -->
				<div class="input-div pass">
					<div class="i">
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>Password</h5>
						<form:input id="pass" type="password" path="password" class="input" onblur="onblurFunction(id);" onkeyup="onkeyupFunction(id);"/>
					</div>
					<span class="error-span error">Please enter your password.</span>
                   	<span class="error-span error">Please enter at least 8 characters.</span>
				</div>
				
				
				<input type="submit" class="btn" value="Register">
			</form:form>
			<h3 class="log">
				Have an account <a class="logLink" href="login">login</a> instead.
			</h3>
		</div>
	</div>
	<script type="text/javascript" src="resources/js/main.js"></script>
	<script type="text/javascript" src="resources/js/register.js"></script>
</body>
</html>