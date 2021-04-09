<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
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

<div class="main-content" align="center" >
<%@ include file="navigation_bar.html" %>

<%@ include file="dashboardAdmin.html" %>
	<div class="content-wrap">
		<h1>Index Page</h1>
		<table align="center">
            <tr>
                <td><a href="./login">Login</a>
                </td>
                <td><a href="./register">Register</a>
                </td>
            </tr>
        </table>
	</div>
</div>





</body>
<%@ include file="footer.html" %>
</html>