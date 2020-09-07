<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="utf-8">

	<!-- Blog Entries Column -->
	<div class="col-md-2">
		<div class="side">
			<div class="container-img">
				<img src="${photo}" alt="avatar" class="pImage" />
				<div class="btnMiddle">
					<!-- <form:form action="saveImage" method="post"
						enctype="multipart/form-data">
						<input type="file" name="photo" size="50"
							placeholder="Upload Your Image" accept="image/*" /> -->
						<!-- 	                          	<button class="btn btn-primary"> -->
						<!-- 	                          	<input type="file" name="photo" size="50" placeholder="Upload Your Image"/> -->
						<!-- 		                          <i class="fa fa-camera"></i> -->
						<!-- 		                          <fa-icon class="camera" [icon]="faCamera"></fa-icon> -->
						<!-- 	                          </button> -->
						<!-- <input type="submit" class="btn" value="Login" />
					</form:form> -->
				</div>
				<h3 class="user">${user.firstName} ${user.lastName}</h3>
			</div>
			<div class="links">
				<div class="link1">
					<a href="#">Add a question</a>
				</div>
				<div class="link2">
					<a href="#">Answer a question</a>
				</div>
				<div class="link3">
					<a href="#">Answered question</a>
				</div>
				<div class="link3">
					<a href="edit-profile">Edit Profile</a>
				</div>
			</div>
		</div>
	</div>



</html>