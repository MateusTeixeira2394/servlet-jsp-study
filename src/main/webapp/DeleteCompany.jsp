<%@page import="br.com.managerapp.constants.CompanyConstants"%>
<%@page import="br.com.managerapp.models.Company"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	Company company = (Company) request.getAttribute("company");
	%>

	<h1>Delete company</h1>

	<p>
		Are you sure to delete the <strong><%=company.getName()%></strong>
		company?
	</p>

	<br>

	<form action="<%=CompanyConstants.DELETE_COMPANY_ACTION%>" method="post">

		<input type="hidden" name="id" value="<%=company.getId()%>" /> <input
			type="submit" value="yes" />

	</form>


</body>
</html>