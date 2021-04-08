<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Church Manager</title>
	<spring:url value="/resources/css/casestudy1.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet">
</head>
<body>

<div class="main-content" align="center">
<%@ include file="navigation_bar.html" %>
<%@ include file="dashboardAdmin.html" %>
<div class="content-wrap">
 <h1>Customer Manager</h1>
    <form method="get" action="./search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    <h3><a href="new">New Member</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Last Name</th>
            <th>E-mail</th>
            <th>Phone Number</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listChurchMember}" var="churchMember">
        <tr>
            <td>${churchMember.id}</td>
            <td>${churchMember.lastName}</td>
            <td>${churchMember.email}</td>
            <td>${churchMember.phoneNumber}</td>
            <td>
                <a href="edit?id=${churchMember.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="delete?id=${churchMember.id}">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
   <%@ include file="footer.html" %>
   
</div>   
</body>
</html>