<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="utf-8">
<head>
<title>Question Engine - Login</title>
<link rel=icon href="resources/images/fav.png">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- <link rel="stylesheet" type="text/css" href="resources/css/loginSS.css"> -->
<link rel="stylesheet" type="text/css" href="resources/css/Lss.css">
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
			<form:form action="home" modelAttribute="tempUser" method="post">
				
				<!-- Email -->
				<div class="input-div one">
					<div class="i">
						<!-- <fa-icon [icon]="faUser"></fa-icon> -->
						<i class="fas fa-user"></i>
					</div>
					<div class="div">
						<h5>E-mail</h5>
						<form:input type="email" path="email" class="input" />
					</div>
				</div>
				<span class="error-span error">This is a required field.</span>
				
				<!-- Password -->
				<div class="input-div pass">
					<div class="i">
						<!-- <fa-icon [icon]="faLock"></fa-icon> -->
						<i class="fas fa-lock"></i>
					</div>
					<div class="div">
						<h5>Password</h5>
						<form:input type="password" path="password" class="input" />
					</div>
				</div>
				<span class="error-span error">This is a required field.</span>
				<br>
				<a href="#">Forgot Password?</a>
				<input type="submit" class="btn" value="Sign In">
			</form:form>
			<h3 class="reg">
				Don't have an account <a class="regLink" href="register">Sign Up</a>
				instead.
			</h3>
		</div>
	</div>

	<script type="text/javascript" src="resources/js/main.js"></script>
</body>
</html>