<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.managerapp.models.Company"%>
<%@ page import="br.com.managerapp.constants.CompanyConstants" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Companies</h1>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>

			<%
			ArrayList<Company> companies = (ArrayList<Company>) request.getAttribute("companies");
			for (Company company : companies) {
			%>

				<tr>
					<td><%= company.getId() %></td>
					<td><%= company.getName() %></td>
					<td><a href="/managerapp<%= CompanyConstants.SHOW_COMPANY_ROUTE %>?id=<%= company.getId() %>">Show</a></td>
					<td><a href="/managerapp<%= CompanyConstants.EDIT_COMPANY_ROUTE %>?id=<%= company.getId() %>">Edit</a></td>
					<td><a href="/managerapp<%= CompanyConstants.DELETE_COMPANY_ROUTE %>?id=<%= company.getId() %>">Delete</a></td>
				</tr>

			<%
			}
			%>
		</tbody>
	</table>
	
	<br>
	<a href="/managerapp<%= CompanyConstants.NEW_COMPANY_ROUTE %>">New Company</a>
</body>
</html>