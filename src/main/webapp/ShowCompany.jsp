<%@page import="br.com.managerapp.models.Company"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.managerapp.constants.CompanyConstants" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% Company company = (Company) request.getAttribute("company"); %>
	
	<h1>Show Company</h1>
	
	<p><strong>Id: </strong><%= company.getId() %></p>
	<p><strong>Name: </strong><%= company.getName() %></p>
	
	<a href="/managerapp<%= CompanyConstants.COMPANIES_ROUTE %>">Back</a> |
	<a href="/managerapp<%= CompanyConstants.EDIT_COMPANY_ROUTE %>?id=<%= company.getId() %>">Edit</a>
	
</body>
</html>