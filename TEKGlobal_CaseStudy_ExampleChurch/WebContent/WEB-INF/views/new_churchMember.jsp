<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Page</title>
<spring:url value="/resources/css/casestudy.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet">
	<!-- CSS Only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	
	
	<div class="main-content" align="center">
		<%@ include file="navigation_bar.html" %>
		<%@ include file="dashboardAdmin.html" %>
		<div class="content-wrap">
		<h1 align="center">Sign Up Page</h1>
	<form:form action="./signup" method="post" modelAttribute="ChurchMember">
	<div>
			<label>Last Name: </label>
			<form:input path="lastName"/>
			<form:errors path="lastName"/>
		</div>
		<div>
			<label>Email: </label>
			<form:input path="email"/>
			<form:errors path="email"/>
		</div>
		<div>
			<label>Phone Number: </label>
			<form:input path="phoneNumber"/>
			<form:errors path="phoneNumber"/>
		</div>
		<div>
			<input type="submit" value="Sign Up">
		</div>
	</form:form>
		</div>
		<%@ include file="footer.html" %>	
	</div>
	
	
</body>
</html>