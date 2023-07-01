<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register</title>
<style>
/* Add your custom CSS styles here */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.header {
	background-color: #007BFF;
	color: #FFFFFF;
	padding: 20px;
	text-align: center;
}

.container {
	max-width: 800px;
	margin: 0 auto;
	padding: 20px;
}

.hero-image {
	width: 100%;
	height: auto;
}

.hero-text {
	text-align: center;
	margin-top: 20px;
}

.btn {
	background-color: #4CAF50;
	color: #FFFFFF;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 5px;
}
</style>
</head>
<body>
	<div class="header">
		<h1>Welcome to Insurance Company</h1>
	</div>

	<div class="container">
		<img class="hero-image" src="insurance_hero_image.jpg"
			alt="Insurance Hero Image">

		<div class="hero-text">
			<h2>Protecting What Matters Most</h2>
			<p>Choose the right insurance coverage for your needs.</p>
			<form:form action="signUp" method="get"
		modelAttribute="Customer">
		<div style="text-align: center;">
			<p>
				<label for="yn">Name:</label>
				<form:input id="yn" path="name" />
			</p>
			<p>
				<label for="em">Email:</label>
				<form:input id="em" path="email" />
			</p>
			<p>
				<label for="ps">Password:</label>
				<form:password id="ps" path="password" />
			</p>
			<p>
				<label for="age">age:</label>
				<form:input id="age" path="age" />
			</p>
			<p>
				<label for="add">address:</label>
				<form:textarea id="add" path="address" />
			</p>
			<p>
				<label for="ph">Phone:</label>
				<form:textarea id="ph" path="phone_number" />
			</p>
			<input type="submit" value="Register" />
		</div>
	</form:form>
		</div>
	</div>
</body>
</html>
