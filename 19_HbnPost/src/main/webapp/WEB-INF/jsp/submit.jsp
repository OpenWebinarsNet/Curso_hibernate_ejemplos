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
<link href="<c:url value="/assets/css/submitform.css" />"
	rel="stylesheet">

<link href="<c:url value="/assets/wysiwyg/bootstrap3-wysihtml5.min.css" />"
	rel="stylesheet">

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
								<jsp:param name="submit" value="submit" />
								<jsp:param name="usuario" value="${sessionScope.userLoggedIn.nombre}" />
							</jsp:include>

						</c:when>
						
						<c:otherwise>
							<jsp:include page="includes/menu.jsp">
								<jsp:param name="submit" value="submit" />
							</jsp:include>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
			<h3 class="text-muted">HbnPost</h3>
		</div>

		<div class="row">
			<form:form method="POST" modelAttribute="post"  action="/submit/newPost" role="form" id="contact-form" class="contact-form">
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<form:input type="text" class="form-control" name="title"
								autocomplete="off" id="title" placeholder="Título" path="titulo" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<form:input type="url" class="form-control" name="url"
								autocomplete="off" id="url" placeholder="URL (opcional)" path="url" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<form:textarea class="form-control textarea" rows="3" name="text"
								id="texto" placeholder="Contenido" path="contenido"></form:textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<button type="submit" class="btn main-btn pull-right">Enviar el post</button>
					</div>
				</div>
			</form:form>
		</div>

		<footer class="footer"> </footer>

	</div>
	<!-- /container -->
	<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
	<script src="<c:url value="/assets/wysiwyg/bootstrap3-wysihtml5.all.min.js" />"></script>
	<script>
		$(document).ready(function() {
			$("#texto").wysihtml5();
		});
	
	</script>

</body>
</html>
