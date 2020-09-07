<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="utf-8">
<head>
    <title>Question Engine</title>
    <link rel=icon href="resources/images/fav.png">
    <link rel="stylesheet" href="resources//css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources//css/stylesheet2.css">
    <script src="resources/js/jquery-3.4.1.min.js"></script>
    <script src="resources/js/popper.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
</head>
<body onload="loadImage();">

	<!-- Navigation -->
	<jsp:include page="template/navbar.jsp"/>


<div class="container-fluid">

  <div class="row">
  
	    <!-- sidebar -->
	    <jsp:include page="template/sidebar.jsp"/>
	    
	    <div class="col">
	    	<form:form action="update" modelAttribute="user" method="post" enctype="multipart/form-data">
	    		<div class="row">&nbsp;</div>
	    		<div class="row justify-content-center">
		    		<!-- First Name -->
		    		<div class="col-md-4">
		    			<div class="div1">
							<h5>Profile Picture</h5>
								<div id="img" class="css-10bmkqe"></div>
								<input type="file" accept=".jpg, .jpeg, .png, .gif" name="profile-photo-file" id="profile-photo-file" class="css-tgm4fq e161llcf0" onchange="previewFile();">
								<label class="userphoto__upload-btn css-1kqwv1a e161llcf1" for="profile-photo-file">Change Photo</label>
								<input type="hidden" name="photo" id="hdnSession" data-value="${photo}" />
						</div>
					</div>
	    		</div>
	    		
	    		<div class="row justify-content-center">
		    		<!-- First Name -->
		    		<div class="col-md-4">
		    			<div class="div1">
							<h5>First Name</h5>
							<form:input id="fn" path="firstName" class="input"/>
						</div>
					</div>
					
					<!-- Last Name -->
		    		<div class="col-md-4">
						<div class="div1">
							<h5>Last Name</h5>
							<form:input id="ln" path="lastName" class="input"/>
						</div>
					</div>
				</div>
				
				<div class="row justify-content-center">
		    		<!-- Email -->
		    		<div class="col-md-4">
		    			<div class="div1">
							<h5>Email</h5>
							<form:input id="fn" path="email" class="input"/>
						</div>
					</div>
					
					<!-- Password -->
		    		<div class="col-md-4">
						<div class="div1">
							<h5>Password</h5>
							<form:input id="ln" type="password" path="password" class="input"/>
						</div>
					</div>
				</div>
	    		
	    		<div class="row justify-content-center">
		    		<!-- Birthday -->
		    		<div class="col-md-4">
		    			<div class="div1">
							<h5>Birthday</h5>
							<input type="date" id="birthday" name="birthday">
<%-- 							<form:input  id="fn" path="userDetail.birthday" class="input"/> --%>
						</div>
					</div>
					
					<!-- Mobile Number -->
		    		<div class="col-md-4">
						<div class="div1">
							<h5>Mobile Number</h5>
							<form:input id="ln" path="userDetail.mobileNumber" class="input"/>
						</div>
					</div>
				</div>
	    		
	    		<div class="row justify-content-center">
		    		<!-- Country -->
		    		<div class="col-md-4">
		    			<div class="div1">
							<h5>Country</h5>
							<form:input id="fn" path="userDetail.country" class="input"/>
						</div>
					</div>
					
					<!-- City -->
		    		<div class="col-md-4">
						<div class="div1">
							<h5>City</h5>
							<form:input id="ln" path="userDetail.city" class="input"/>
						</div>
					</div>
				</div>
	    		
	    		<input type="submit" class="btn" value="Update">
	    	</form:form>
		</div>
		
	</div>
	
</div>

    <!-- Pagination -->
    <ul class="pagination justify-content-center mb-4">
      <li class="page-item">
        <a class="page-link" href="#">See More ..</a>
      </li>
    </ul>

		<!-- Footer -->
		<footer class="footerColor py-5 bg-dark">
		  <div class="container">
		    <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
		  </div>
		</footer>
	<script type="text/javascript" src="resources/js/main.js"></script>
	<script type="text/javascript" src="resources/js/profile.js"></script>
</body>
</html>  

