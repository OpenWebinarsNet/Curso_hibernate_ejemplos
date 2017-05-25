<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>HbnPost</title>

<!-- Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"
	rel="stylesheet">


<!-- Custom styles for this template -->

<link href="<c:url value="/assets/css/jumbotron-narrow.css" />"
	rel="stylesheet">
<link href="<c:url value="/assets/css/login.css" />" rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="container">
		<div class="header clearfix">
			<nav>
				<ul class="nav nav-pills pull-right">
					<!-- <li role="presentation" class="active"><a href="#">Home</a></li>
					<li role="presentation"><a href="#">About</a></li>
					<li role="presentation"><a href="/autores">Autores</a></li>-->
					<c:choose>
						<c:when test="${not empty sessionScope.userLoggedIn}">
							<jsp:include page="includes/menu_logged.jsp" flush="true">
								<jsp:param name="inicio" value="inicio" />
								<jsp:param name="usuario"
									value="${sessionScope.userLoggedIn.nombre}" />
							</jsp:include>

						</c:when>
						<c:otherwise>
							<jsp:include page="includes/menu.jsp">
								<jsp:param name="inicio" value="inicio" />
							</jsp:include>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
			<h3 class="text-muted">HbnPost</h3>
		</div>

		<div class="row">
			<div class="col-lg-6 col-lg-offset-3">
				<form:form class="form-signin" method="POST" action="/login"
					modelAttribute="userLogin">
					<h2 class="form-signin-heading">Formulario de acceso</h2>
					<!--<form:label path="email" class="sr-only" />Email</label>-->
					<form:input type="email" id="inputEmail" class="form-control"
						placeholder="Email" path="email" required="required"
						autofocus="autofocus" />
					<!--<form:label path="password" class="sr-only" />Password</label>-->
					<form:input type="password" id="inputPassword" class="form-control"
						placeholder="Password" path="password" required="required" />
					<p></p>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				</form:form>
			</div>
		</div>

		<c:if test="${not empty error}">
			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">

					<div class="alert alert-danger alert-dismissible fade in"
						role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<c:out value="${error}" />
					</div>
				</div>
			</div>

		</c:if>

		<footer class="footer"> </footer>

	</div>
	<!-- /container -->
	<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</body>
</html>
