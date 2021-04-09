<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/css/casestudy.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet">
<!-- CSS Only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/39f198be01.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container" id="container">
		<div class="form-container sign-up-container">

			<form:form action="./registersuccess" method="post"
				modelAttribute="user">
				<h1>Create Account</h1>
				<div class="cocial-container">
					<a href="#" class="social"><i class="fa fa-facebook"></i></a> <a
						href="#" class="social"><i class="fa fa-google"></i></a> <a
						href="#" class="social"><i class="fa fa-linkedin"></i></a>
				</div>
				<span>or use your email for registration</span>
				<form:input type="text" class="form-control" placeholder="Username"
					path="username" />
				<form:errors path="username" />
				<form:input type="email" class="form-control"
					id="exampleFormControlInput1" placeholder="name@example.com"
					path="email" />
				<form:errors path="email" />
				<form:input class="form-control" type="password" path="password" />
				<form:errors path="password" />
				<button>Register</button>
			</form:form>
		</div>
		<div class="form-container sign-in-container">
			<form:form action="./loginsuccess" method="post"
				modelAttribute="userCred">
				<h1>Sign In</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fa fa-facebook"></i></a> <a
						href="#" class="social"><i class="fa fa-google"></i></a> <a
						href="#" class="social"><i class="fa fa-linkedin"></i></a>
				</div>
				<span>or use your account</span>
				<form:input type="email" path="email" />
				<form:errors path="email" cssClass="error"/>
				<form:password path="password"/>
				<form:errors path="password" cssClass="error"/>
				<a href="#">Forgot Your Password</a>
			</form:form>



		</div>

	</div>
</body>
</html>