<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
<spring:url value="/resources/css/casestudy.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet">
	<!-- CSS Only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>

<div class="main-content" align="center"> 
<%@ include file="navigation_bar.html" %>
<%@  include file="dashboardAdmin.html" %>
	<div class="content-wrap">
	<h1>Profile Page</h1>
	<div >
	<form:form action="./profile/save" method="post" modelAttribute="ChurchMember">
	<div class="col-sm-2">
			<label>Member ID </label>
			<form:input class="form-control" type="text" path="member.id" readonly="true"/>
			<form:errors path="id"/>
		</div>
	<div class="col-sm-2">
			<label class="form-label">First Name </label>
			<form:input type="text" class="form-control" placeholder="firstname" path="firstName"/>
			<form:errors path="firstName"/>
		</div>
			<div class="col-sm-2">
			<label class="form-label">Last Name: </label>
			<form:input type="text" class="form-control" placeholder="lastname" path="lastName"/>
			<form:errors path="lastName"/>
		</div>
			<div class="col-sm-2">
			<label class="form-label">Address</label>
			<form:input type="text" class="form-control" placeholder="Home Address" path="address"/>
			<form:errors path="address"/>
		</div>
		<div class="col-sm-2">
			<label  class="form-label">Email: </label>
			<form:input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com" path="email"/>
			<form:errors path="email"/>
		</div>
		<div class="col-sm-2">
			<label>Phone Number </label>
			<form:input class="form-control" placeholder="111-111-1111" path="phoneNumber"/>
			<form:errors path="phoneNumber"/>
		</div>
		<div>
			<input class="btn btn-primary" type="submit" value="Update">
		</div>
	</form:form>
	</div>
	</div>
	<%@ include file="footer.html" %>
	
</div>

	
	
</body>
</html>