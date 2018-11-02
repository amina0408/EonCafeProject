<%@page import="com.model.Customer"%>
<%@page import="com.dao.CustomerDaoImpl"%>
<%@page import="com.dao.CustomerDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
	Object attr = request.getAttribute("customerList");
	List<Customer> customerList1 = (List<Customer>) attr;

		
	%>

	<table border=1>
		<tr>
			<td>CustomerId</td>
			<td>CustomerName</td>
			<td>CustomerEmail</td>
			<td>CustomerPassword</td>

		</tr>

		<%
			for (Customer e : customerList1) {
		%>
		<tr>
			<td><%=e.getCid() %></td>

			<td><%=e.getCname() %></td>
			<td><%=e.getCemail() %></td>
			<td><%=e.getCpassword() %></td>

		</tr>

		<%
			}
		%>

	</table>


	<form action="ViewAdminOperation.jsp" method="post">
		<input type="submit" value="GO TO OPERATIONS PAGE" />
	</form>
	<form action="ViewAdminLogin.jsp" method="post">
	<input type="submit" value="LOGOUT" />
	</form>






















</body>
</html>