<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="br.com.managerapp.constants.CompanyConstants" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Company Form</title>
</head>
<body>
	
	<h1>New Company</h1>
	
	<form action="<%= CompanyConstants.NEW_COMPANY_ACTION %>" method="post">
		
		<label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter the company's name" required>

        <br><br>

        <input type="submit" value="Submit">
	
	</form>
	<br>
	<a href="/managerapp<%= CompanyConstants.COMPANIES_ROUTE %>">Back</a>
</body>
</html>