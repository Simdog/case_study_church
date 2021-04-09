<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/css/casestudy1.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet">
<!-- CSS Only -->
<!-- https://www.youtube.com/watch?v=Ec1G5Hp-8Ko -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
	<link href="${mainCss}" rel="stylesheet">
<script src="https://kit.fontawesome.com/39f198be01.js"
	crossorigin="anonymous"></script>
	

</head>
<body class = "body">
	<div class="contain" id="container">
		<div class="form-container sign-up-container">

			<form class="form" action="./registersuccess" method="post"
				>
				<h1>Create Account</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fa fa-facebook"></i></a> <a
						href="#" class="social"><i class="fa fa-google"></i></a> <a
						href="#" class="social"><i class="fa fa-linkedin"></i></a>
				</div>
				<span>or use your email for registration</span>
				<input class="input" type="text" class="form-control" placeholder="Username"
					path="username" name="username" />
				<input class="input" type="email" class="form-control"
					id="exampleFormControlInput1" placeholder="name@example.com"
					path="email" name="email" />
				<input class="input" type="password" class="form-control" placeholder="password" path="password" name="password"/>
				<button class="button">Register</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form class="form" action="./loginsuccess" method="post"
				modelAttribute="userCred">
				<h1>Sign In</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fa fa-facebook"></i></a> <a
						href="#" class="social"><i class="fa fa-google"></i></a> <a
						href="#" class="social"><i class="fa fa-linkedin"></i></a>
				</div>
				<span>or use your account</span>
				<input class="input" type="email" path="email" name="email" placeholder="name@example.com"/>
				<input class="input" type="password" path="password" name="password" placeholder="password"/>
				<a href="./forgotpassword">Forgot Your Password</a>
				
				<button class="button">Log In</button>
			</form>
		</div>


	</div>
	<script type="text/javascript">
		const signUpButton = ducument.getElementById("signUp");
		const signInButton = ducument.getElementById("signIn");
		const container = ducument.getElementById("container");
		
		signUpButton.addEventListener("click", () => {
			container.classList.add("right-panel-active");
		});
		signInButton.addEventListener("click", () => {
			container.classList.remove("right-panel-active");
		});

	</script>

</body>
</html>