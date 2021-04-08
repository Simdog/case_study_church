<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Church Manager</title>
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
		<h2>Attendance Manager</h2>
		<form:form action="./updateattendance" method="post"
			modelAttribute="attendance">
			<h3>Church Members</h3>
			<table class="table table-striped" border="1" cellpadding="5">
				<tr>
					<th>ID</th>
					<th>Last Name</th>
					<th>E-mail</th>
					<th>Phone Number</th>
					<th>In Attendance</th>
					<th>Date Of Attendance</th>


				</tr>
				<c:forEach items="${listChurchMember}" var="churchMember"
					varStatus="status">
					<tr>
						<td><input path="member.id" name="churchMemberId" value="${churchMember.id }"
							readonly="true" /></td>
						<td><input name="churchMemberLastName"
							value="${churchMember.lastName }" readonly="true" /></td>
						<td><input name="churchMemberEmail"
							value="${churchMember.email }" readonly="true" /></td>
						<td><input name="churchMemberPhoneNumber"
							value="${churchMember.phoneNumber }" readonly="true" /></td>
						<td>
							<input type="radio"  name="churchMemberAttendance${churchMember.id }"   value="1" /> 
							<input type="radio"  name="churchMemberAttendance${churchMember.id }"   value="0" checked/>
						</td>
						 <td><input name="attendanceDate" type="date"  ></td>		



					</tr>
				</c:forEach>
			</table>
			<div>
				<input class="btn btn-primary" type="submit" value="Enter">
			</div>
		</form:form>

	</div>
	<%@ include file="footer.html" %>
</div>

	
</body>
</html>