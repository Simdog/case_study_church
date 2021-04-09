<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
	<spring:url value="/resources/css/casestudy1.css" var="mainCss" />
	
	<!-- CSS Only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<link href="${mainCss}" rel="stylesheet">
</head>
<body>
<%
%>
<c:if test="${statut == 'ADMIN'}">
...
</c:if>



<div class="main-content" align="center" >
<%@ include file="navigation_bar.html" %>

<%@  include file="dashboardAdmin.html" %>

	<div class="content-wrap index">
		<h1 class="pointer">Index Page</h1>
		<div>
			    <p class="displaylog"><a class="logs" href="./login">Login</a></p>
			    <p class="displayreg"><a class="logs" href="./register">Register</a></p>

		</div>
	</div>
</div>





</body>
<%@ include file="footer.html" %>
</html>