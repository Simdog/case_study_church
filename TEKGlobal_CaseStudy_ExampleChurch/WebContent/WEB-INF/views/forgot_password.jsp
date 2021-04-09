<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
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
<%@ include file="navigation_bar.html" %>

	<h1>Forgot your password?</h1>
	<h2>We will go through some steps to recover it ...</h2>
	<div>
	<p>Please enter your Username and Email</p>
	</div>
	<form method="get" action="./forgotpasswordrequest">
        <input type="text" name="forgotPassUserName" placeholder="Username"  /> &nbsp;
        <input type="text" name="forgotPassEmail" placeholder="Email" /> &nbsp;
        
        <input type="submit" value="submit" />
    </form>
    
	<table class="hide" align="center" border="5px">
	
			<tr>
			<td>User password:</td>
			<td>${userCred.password}</td>
		</tr>

	</table>
	
</body>
</html>