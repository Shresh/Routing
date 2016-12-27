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
<title>Edit Profile</title>
</head>
<body>
	<!-- Start navbar -->
	<nav class="navbar navbar-inverse navigation-clean-button"
		style="border-radius: 0px !important; margin-bottom: 0px;">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navcol-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand navbar-link" href="adminHome">Routing</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navcol-1">
				<ul class="nav navbar-nav">
					<li role="presentation"><a href="adminHome">Home
							<span class="sr-only"></span>
					</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Profile<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li role="presentation"><a href="adminVProfile">View
									Profile</a></li>
							<li role="presentation" class = "active"><a href="adminEProfile">Edit
									Profile</a></li>
						</ul></li>
					<li class="dropdown" role="presentation"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Bus<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li role="presentation"><a href="adBus">Add Bus</a></li>
							<li role="presentation"><a href="viewBus">View Bus</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Location<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li role="presentation"><a href="addLocation">Add
									Location</a></li>
							<li role="presentation"><a href="viewLocation">View
									Location</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Set
							Route<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li role="presentation"><a href="addRoute">Add Route</a></li>
							<li role="presentation"><a href="viewRoute">View Route</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout"><span
							class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- End Nav bar -->

	<p>
		<br /> <br /> <br /> <br /> <br /> <br />
	</p>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="text-center">
							<h2>Edit Profile</h2>
						</div>
						<!-- Start Form -->
						<form:form method="POST" modelAttribute="user"
							action="${pageContext.request.contextPath}/updateAdminProfile" name="registration" onsubmit="return validate();">
							<div class="form-group">
								<label for="firstName">First Name</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-user"></i></span>
									<form:input path="firstName" disabled="false"
										class="form-control" aria-describedby="basic-addon1"  placeholder="First Name"/>
								</div>
							</div>
							<div class="form-group">
								<label for="lastName">Last Name</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-user"></i></span>
									<form:input path="lastName" disabled="false"
										class="form-control" aria-describedby="basic-addon1"  placeholder="Last Name"/>
								</div>
							</div>
							<div class="form-group">
								<label for="dateOfBirth">Date of Birth</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-gift"></i></span>
									<form:input path="dateOfBirth" disabled="false"
										class="form-control" aria-describedby="basic-addon1"  placeholder="Date of Birth"/>
								</div>
							</div>
							<div class="form-group">
								<label for="gender">Gender</label>
								<div class="input-group">


									<label class="radio-inline"> <form:radiobutton
											path="gender" value="Male" disabled="false" />Male
									</label> <label class="radio-inline"> <form:radiobutton
											path="gender" value="Female" disabled="false" />Female
									</label> <label class="radio-inline"> <form:radiobutton
											path="gender" value="Others" disabled="false" />Others
									</label>

								</div>
							</div>
							<div class="form-group">
								<label for="contactNo">Contact Number</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-phone"></i></span>
									<form:input path="contactNo" disabled="false"
										class="form-control" aria-describedby="basic-addon1"  placeholder="Contact Number"/>
								</div>
							</div>
							<div class="form-group">
								<label for="username">Username</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-user"></i></span>
									<form:input path="username" readonly="true"
										class="form-control" aria-describedby="basic-addon1" placeholder="Username"/>
								</div>
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-star"></i></span>
									<form:input type="password" path="password" disabled="false"
										class="form-control" aria-describedby="basic-addon1" placeholder="Password"/>
								</div>
							</div>
							<div class="form-group">
								<label for="cpassword">Confirm Password</label>
								<div class="input-group">
									<span class="input-group-addon" id="basic-addon1"><i
										class="glyphicon glyphicon-star"></i></span>
									<input type="password" name="cpassword" id = "cpassword" class="form-control" 
									placeholder="Confirm Password" aria-describedby="basic-addon1"/>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">
								<i class="glyphicon glyphicon-ok"></i> Done
							</button>
							<form:hidden path="role" value="Admin" />
							<form:hidden path="id" />
						</form:form>
						<!-- End Form -->
					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		<hr />
	</div>
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
						<a href="#"> <i id="social-fb"></i>
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
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>