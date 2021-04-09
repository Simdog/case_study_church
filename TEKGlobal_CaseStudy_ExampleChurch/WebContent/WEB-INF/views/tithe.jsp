<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/css/casestudy1.css" var="mainCss" />
	<!-- CSS Only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<link href="${mainCss}" rel="stylesheet">
</head>
<body>
<div class="main-content">
<%@ include file="navigation_bar.html" %>
<%@ include file="dashboardAdmin.html" %>
	<div class="container content-wrap" align="center">
	<h1>Tithe Manager</h1>


<form:form action="./tithe" method="post" modelAttribute="tithe">
	<div class="col-sm-2">
			<label class="form-label">Tithe Amount </label>
			<form:input class="form-control" placeholder="$" path="titheAmount"/>
			<form:errors path="titheAmount"/>
		</div>
		<div class="col-sm-2">
			<label  class="form-label">Date Collected </label>
			<form:input type="date" class="form-control" id="exampleFormControlInput1" path="date"/>
			<form:errors path="date"/>
		</div>
		<div class="col-sm-2">
			<label>Member ID </label>
			<form:input class="form-control" type="text" path="member.id"/>
			<form:errors path="member.id"/>
		</div>
		<div>
			<input class="btn btn-primary" type="submit" value="Enter">
		</div>
	</form:form>
	<h3><a href="new">Church Members</a></h3>
    <table class="table table-striped" border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Last Name</th>
            <th>E-mail</th>
            <th>Phone Number</th>

        </tr>
        <c:forEach items="${memberMap}" var="churchMember">
        <tr>
            <td>${churchMember.id}</td>
            <td>${churchMember.lastName}</td>
            <td>${churchMember.email}</td>
            <td>${churchMember.phoneNumber}</td>

        </tr>
        </c:forEach>
    </table>
	
	</div>
	<%@ include file="footer.html" %>
	
</div>



</body>
</html>