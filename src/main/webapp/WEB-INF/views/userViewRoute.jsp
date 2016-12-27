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
	src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Article-Clean.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Footer-Clean.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/Navigation-with-Button1.css">
<title>Route</title>
</head>
<body>

	<!-- Start navbar -->
	<nav class="navbar navbar-inverse navigation-clean-button  navbar-fixed-top "
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
				<a class="navbar-brand navbar-link" href="userhome">Routing</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="navcol-1">
				<ul class="nav navbar-nav">
					<li role = "presentation"><a href="userhome">Home <span
							class="sr-only"></span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Profile<span class="caret"></span></a>
						<ul class="dropdown-menu" role = "menu">
							<li role = "presentation"><a href="userVProfile">View Profile</a></li>
							<li role = "presentation"><a href="userEProfile">Edit Profile</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Route<span class="caret"></span></a>
						<ul class="dropdown-menu" role = "menu">
							<li role = "presentation" class = "active"><a href="userViewRoute">View Route</a></li>
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
		<br /> <br /> <br /> <br />
	</p>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="text-center">
							<h2>Routes</h2>
						</div>
						<!-- Start table -->
						<table class="table table-bordered table-striped" id="myTable">
							<thead class="thead-inverse">
								<tr>
									<th>Bus No</th>
									<th>From</th>
									<th>To</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="row" items="${routeList}">
									<tr>
										<td>${row.getBus().getBusNo()}</td>
										<td>${row.getLocation1().getLocation()}</td>
										<td>${row.getLocation2().getLocation()}</td>
										<td><input type="button"
											onclick="viewBusRoute(${row.id })" value="View"
											style="color: green" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- End table -->
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
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
	<script type="text/javascript">
		function viewBusRoute(id){
			location.href = "${pageContext.request.contextPath}/" + id + "/viewBRoute";
		}
		$(document).ready(function(){
	        $('#myTable').DataTable();
	    });
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>