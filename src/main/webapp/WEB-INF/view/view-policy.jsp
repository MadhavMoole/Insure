<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="temp" items="${PolicyList}">
				<tr>
					<td>${temp.getScheme_number()}</td>
        			<td>${temp.getPolicy_name()}</td>
        			<td>${temp.getAmount()}</td>
        			<td>${temp.getMax_no_of_years()}</td>
        			<td>
        				<form:form action="upPol" method="POST" modelAttribute="Policy">
							<form:input type="hidden" path="scheme_number" value="${temp.getScheme_number()}"/>
							<form:input type="hidden" path="policy_name" value="${temp.getPolicy_name()}"/>
							<form:input type="hidden" path="amount" value="${temp.getAmount()}"/>
							<form:input type="hidden" path="max_no_of_years" value="${temp.getMax_no_of_years()}"/>
							<button type="submit" >Update</button>
						</form:form>
						<form:form action="delPol" method="GET" modelAttribute="Policy">
							<form:input type="hidden" path="scheme_number" value="${temp.getScheme_number()}"/>
							<form:input type="hidden" path="policy_name" value="${temp.getPolicy_name()}"/>
							<form:input type="hidden" path="amount" value="${temp.getAmount()}"/>
							<form:input type="hidden" path="max_no_of_years" value="${temp.getMax_no_of_years()}"/>
							<button type="submit">Delete</button>
						</form:form>
        			</td>
        		</tr>
    		</c:forEach>
		</tbody>
	</table>
</body>
</html>