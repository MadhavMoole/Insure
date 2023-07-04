<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Customers</title>
</head>
<body>
	<table border="1" style="text-align: center;">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
				<th>Phone Number</th>
				<th>Email</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="temp" items="${customers}">
				<tr>
					<td>${temp.getId()}</td>
					<td>${temp.getName()}</td>
					<td>${temp.getAge()}</td>
					<td>${temp.getAddress()}</td>
					<td>${temp.getPhone_number()}</td>
					<td>${temp.getEmail()}</td>
					<td>
						<form action="view-policy" method="GET">
							<input type="hidden" name="customerID" value="${temp.getId()}">
							<button type="submit" >Show Policies</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>