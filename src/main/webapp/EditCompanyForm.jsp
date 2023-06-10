<%@page import="br.com.managerapp.models.Company"%>
<%@page import="br.com.managerapp.constants.CompanyConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% Company company = (Company) request.getAttribute("company"); %>

	<h1>Edit Company</h1>

	<form action="<%= CompanyConstants.EDIT_COMPANY_ACTION %>" method="post">

		<input type="text" id="id" value="<%= company.getId() %>"
			name="id" style="display:none;" required>
			
		<label for="name">Name:</label> <input type="text" id="name" value="<%= company.getName() %>"
			name="name" placeholder="Enter the company's name" required>

		<br>
		<br> <input type="submit" value="Submit">

	</form>
	
	<br>
	
	<a href="/managerapp<%=CompanyConstants.COMPANIES_ROUTE%>">Back</a>

</body>
</html>