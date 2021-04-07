<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<spring:url value="/resources/css/casestudy.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet">
	<!-- CSS Only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	<h1>Registration Page</h1>
	<div class="jumbotron">
	<form:form action="./register" method="post" modelAttribute="user">
	<div class="col-sm-2">
			<label class="form-label">User Name: </label>
			<form:input type="text" class="form-control" placeholder="Username" path="username"/>
			<form:errors path="username"/>
		</div>
		<div class="col-sm-2">
			<label  class="form-label">Email: </label>
			<form:input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com" path="email"/>
			<form:errors path="email"/>
		</div>
		<div class="col-sm-2">
			<label>Password: </label>
			<form:input class="form-control" type="password" path="password"/>
			<form:errors path="password"/>
		</div>
		<div>
			<input class="btn btn-primary" type="submit" value="Register">
		</div>
	</form:form>
	</div>
	
</body>
</html>