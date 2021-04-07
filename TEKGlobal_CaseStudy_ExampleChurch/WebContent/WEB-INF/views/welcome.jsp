<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<spring:url value="/resources/css/casestudy.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet">
	<!-- CSS Only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	<h1>User Welcome Page</h1>
	<%@ include file="navigation_bar.html" %>
	<h2>Welcome ${currentUser.username}</h2>
	<p> </p>
</body>
</html>