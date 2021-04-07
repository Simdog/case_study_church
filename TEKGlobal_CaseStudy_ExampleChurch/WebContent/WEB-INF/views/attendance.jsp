<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Church Manager</title>
</head>
<body>
	<div align="center">
		<h2>Attendance Manager</h2>
		<form:form action="./updateattendance" method="post"
			modelAttribute="attendance">
			<h3>Church Members</h3>
			<table border="1" cellpadding="5">
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
						<td><input name="churchMemberId" value="${churchMember.id }"
							readonly="true" /></td>
						<td><input name="churchMemberLastName"
							value="${churchMember.lastName }" readonly="true" /></td>
						<td><input name="churchMemberEmail"
							value="${churchMember.email }" readonly="true" /></td>
						<td><input name="churchMemberPhoneNumber"
							value="${churchMember.phoneNumber }" readonly="true" /></td>
						<td><form:radiobutton name="status_[${status.index}]" path="isPresent" value="true" /> 
						<form:radiobutton name="status_[${status.index}]" path="isPresent" value="false" /></td>
						<td><form:input type="date" class="form-control"
								id="exampleFormControlInput1" name="attendanceDate" path="date" />
							<form:errors path="date"></form:errors></td>


					</tr>
				</c:forEach>
			</table>
			<div>
				<input class="btn btn-primary" type="submit" value="Enter">
			</div>
		</form:form>

	</div>
</body>
</html>