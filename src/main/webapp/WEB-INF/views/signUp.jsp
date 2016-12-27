<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/views/clear.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/validate/dist/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/form_validation.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Article-Clean.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Footer-Clean.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Navigation-with-Button1.css">
<title>Sign Up</title>
</head>
<body>
	<!-- Start navbar -->
	<nav class="navbar navbar-inverse navigation-clean-button"
		style="border-radius: 0px !important; margin-bottom: 0px;">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navcol-1"
					aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand navbar-link" class="active" href="home">Routing</a>
			</div>

			<div id="navcol-1" class="collapse navbar-collapse">

				<p class="navbar-text navbar-right actions">
					<a href="signUp" class="btn btn-default action-button"
						role="button"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a> <a href="login" class="nav-bar-link login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a>
				</p>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<!-- End Nav bar -->
	<p>
		<br /> <br /> <br /> <br /> <br /> <br />
	</p>
	<div class="container">
		<div class="row">
			<div class="col-md-7">
			<img src="${pageContext.request.contextPath}/resources/img/bus1.jpg"
					alt="bus1" class="img-responsive" style="width: 750px; height: 600px; padding-top : 150px; padding-bottom : 10px">
			</div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-body" style = "background-color: honeydew">
						<div class="text-center">
							<h2>Sign Up</h2>
						</div>
						<!-- Start Login Form -->
						<form method="POST" name="registration"
							onsubmit="return validate();">
							<div class="form-group">
								<label for="firstName">First Name</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-user"></i></span> <input type="text"
										name="firstName" id="firstName" class="form-control"
										placeholder="First Name" aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="form-group">
								<label for="lastName">Last Name</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-user"></i></span> <input type="text"
										name="lastName" id="lastName" class="form-control"
										placeholder="Last Name" aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="form-group">
								<label for="dateOfBirth">Date of Birth</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-gift"></i></span> <input type="text"
										name="dateOfBirth" id="dateOfBirth" class="form-control"
										placeholder="Date of Birth(mm/dd/yyyy)"
										aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="form-group">
								<label for="gender">Gender</label>
								<div class="input-group">
									<label class="radio-inline"> <input type="radio"
										name="gender" value="Male" checked> Male
									</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="Female"> Female
									</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="Others"> Others
									</label>
								</div>
							</div>
							<div class="form-group">
								<label for="contactNo">Contact Number</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-phone"></i></span> <input type="text"
										name="contactNo" id="contactNo" class="form-control"
										placeholder="Contact Number" aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="form-group">
								<label for="username">Username</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-user"></i></span> <input type="text"
										name="username" class="form-control" placeholder="Username"
										aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-star"></i></span> <input type="password"
										name="password" id="password" class="form-control"
										placeholder="Password" aria-describedby="basic-addon1">
								</div>
							</div>
							<div class="form-group">
								<label for="cpassword">Confirm Password</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-star"></i></span> <input type="password"
										name="cpassword" id="cpassword" class="form-control"
										placeholder="Confirm Password" aria-describedby="basic-addon1">
								</div>
							</div>
							<h6 style="color: red">${failedSignup}</h6>
							<h6 style="color: green">${successSignup}</h6>
							<button type="submit" class="btn btn-primary">
								<i class="glyphicon glyphicon-log-in"></i> Sign Up
							</button>
						</form>
						<!-- End Login Form -->
					</div>
				</div>
			</div>
			
			<div class="col-md-1"></div>
		</div>
	</div>
	<hr/>
	<div class="footer-clean">
		<footer>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-3 col-sm-2 item"></div>
					<div class="col-md-3 col-sm-2 item"></div>
					<div class="col-md-3 col-sm-2 item">
						<h3>About</h3>
						<ul>
							<li><a href="#">Team</a></li>
						</ul>
					</div>
					<div class="col-md-3 item social">
						<a href="#"> <i class="icon ion-social-facebook"></i>
						</a> <a href="#"> <i class="icon ion-social-twitter"></i>
						</a> <a href="#"> <i class="icon ion-social-snapchat"></i>
						</a> <a href="#"> <i class="icon ion-social-instagram"></i>
						</a>
						<p class="copyright">Shreesh Prasad Shrestha@2016</p>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>