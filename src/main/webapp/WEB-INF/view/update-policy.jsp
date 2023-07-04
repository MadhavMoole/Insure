<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Policy</title>
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
			<form:form action="updatePolicy" method="get"
		modelAttribute="Policy">
		<div style="text-align: center;">
			<p>
			  <label for="pol">Select Policy:</label>
		      <form:select
                id="pol"
                path="policy_name"
              >
                <option value="Select">Select</option>
                <option value="Life Insurance">Life Insurance</option>
                <option value="Drivers Insurance">Drivers Insurance</option>
                <option value="Property Insurance">Property Insurance</option>
              </form:select>
			</p>
			<p>
				<label for="age">Years:</label>
				<form:input id="yrs" path="max_no_of_years" />
			</p>
			<p>
				<label for="age">Amount:</label>
				<form:input id="amt" path="amount" />
			</p>
			
			<input type="submit" value="Update" />
		</div>
	</form:form>
		</div>
	</div>

</body>
</html>