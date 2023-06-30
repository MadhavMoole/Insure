<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Policies</title>
</head>
<body >
	<table border="1" style="text-align:center;">
		<thead>
			<tr>
				<th>Scheme Number</th>
				<th>Policy Name</th>
				<th>Amount Paid</th>
				<th>Years valid</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="temp" items="${PolicyList}">
				<tr>
					<td>${temp.getScheme_number()}</td>
        			<td>${temp.getPolicy_name()}</td>
        			<td>${temp.getAmount()}</td>
        			<td>${temp.getMax_no_of_years()}</td>
        		</tr>
    		</c:forEach>
		</tbody>
	</table>
</body>
</html>