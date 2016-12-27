<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/clear.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Article-Clean.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Footer-Clean.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Navigation-with-Button1.css">
<title>Routing</title>
</head>
<body>
	<!-- Start navbar -->
	<nav class="navbar navbar-inverse navigation-clean-button"
		style="border-radius: 0px !important; margin-bottom: 0px;">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navcol-1" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand navbar-link" class="active" href="">Routing</a>
			</div>

			<div id="navcol-1" class="collapse navbar-collapse">

				<p class="navbar-text navbar-right actions">
					<a href="signUp" class="btn btn-default action-button" role="button"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a>
					<a href="login" class="nav-bar-link login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a>
				</p>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<!-- End Nav bar -->
	<p>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
	</p>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="text-center">
							<h2>Welcome</h2>
						</div>

					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
		<hr />
		<div class="footer-clean">
			<footer>
				<div class = "container-fluid">
					<div class = "row">
						<div class = "col-md-3 col-sm-2 item">					
						</div>
						<div class = "col-md-3 col-sm-2 item">				
						</div>
						<div class = "col-md-3 col-sm-2 item">	
							<h3>About</h3>
								<ul>
									<li><a href= "#">Team</a> </li>
								</ul>			
						</div>
						<div class = "col-md-3 item social">
							<a href = "#">
								<i class = "icon ion-social-facebook"></i>
							</a>					
							<a href = "#">
								<i class = "icon ion-social-twitter"></i>
							</a>				
							<a href = "#">
								<i class = "icon ion-social-snapchat"></i>
							</a>					
							<a href = "#">
								<i class = "icon ion-social-instagram"></i>
							</a>
							<p class = "copyright">Shreesh Prasad Shrestha@2016</p>				
						</div>
					</div>
				</div>
			</footer>
		</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>




