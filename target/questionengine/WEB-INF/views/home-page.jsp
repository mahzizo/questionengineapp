<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="utf-8">
<head>
	<title>Question Engine</title>
	<link rel=icon href="resources/images/fav.png">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/css/stylesheet.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<script src="resources/js/jquery-3.4.1.min.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>

<!-- 	<!-- Navigation -->
<jsp:include page="template/navbar.jsp"/>

	<c:if test="${posts != null}">
	
	<!-- Content -->
	<div class="container padding">

		<div class="row">

			<!-- Blog Entries Column -->
			<div class="card col-md-8 ">

				<div class="addPost pt-4">
					<button class="post btn btn-success float-left">
						Add a question 
						<i class="fas fa-plus"></i>
					</button>
				</div>
					

				<div class="clear"></div>

				<!-- Blog Post -->
				<c:forEach items="${posts}" var="post">
					<div class="card mb-4 mt-3">
						<div class="card-body">
							<h2 class="card-title">${post.title}</h2>
							<p class="card-text">${post.body}</p>
							<a href="#" class="btn btn-primary">Read More &rarr;</a>
						</div>
						<div class="card-footer text-muted">
							Posted on January 1, 2017 by <a href="#">Start Bootstrap</a>
						</div>
					</div>
				</c:forEach>



				<!-- Pagination -->
				<ul class="pagination justify-content-center mb-4">
					<li class="page-item"><a class="page-link" href="#">&larr;
							Older</a></li>
					<li class="page-item disabled"><a class="page-link" href="#">Newer
							&rarr;</a></li>
				</ul>

			</div>

			<!-- Sidebar Widgets Column -->
			<div class="col-md-4">

				<!-- Search Widget -->
				<div class="card my-4">
					<h5 class="card-header">Search</h5>
					<div class="card-body">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search for..."> <span
								class="input-group-btn">
								<button class="btn btn-secondary" type="button">
									Go
									<fa-icon [icon]="faArrowRight"></fa-icon>
								</button>
							</span>
						</div>
					</div>
				</div>

				<!-- Categories Widget -->
				<div class="card my-4">
					<h5 class="card-header">Categories</h5>
					<div class="card-body">
						<div class="row">
							<div class="col-lg-6">
								<ul class="list-unstyled mb-0">
									<li><a href="#">History</a></li>
									<li><a href="#">Literature</a></li>
									<li><a href="#">Science</a></li>
								</ul>
							</div>
							<div class="col-lg-6">
								<ul class="list-unstyled mb-0">
									<li><a href="#">Programming</a></li>
									<li><a href="#">Health</a></li>
									<li><a href="#">Food</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<!-- Side Widget -->
				<div class="card my-4">

					<h5 class="card-header">Side Widget</h5>
					<div class="card-body">You can put anything you want inside
						of these side widgets.And feature the new Bootstrap 4 card
						containers!</div>
				</div>

			</div>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
	
	</c:if>
	<c:if test="${posts == null}">
		<h2>Error while Loading Content ...</h2> 
	</c:if>
	
	<!-- Footer -->
	<footer class="footerColor py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
	</footer>
</body>
</html>