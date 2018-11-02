<%@page import="com.model.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.OrderDaoImpl"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<form method="post" action="VendorSendingMailServlet">
</head>
<body>

<%
 		Object attr=request.getAttribute("orderList");
 		List<Order> order1List=(List<Order>)attr;
 		
  %>

<table border=1>
<tr>
<td>OrderId</td>
<td>CustomerId</td>

<td>CustomerName</td>
<td>CustomerEmail</td>

<td>VendorId</td>
<td>MenuId</td>
<td>MenuName</td>
</tr>

<%
for(Order order1:order1List )
{
%>	
<tr>
	<td><%=order1.getOid() %></td>
	<td><%=order1.getCid()%> </td>
	<td><%=order1.getCname() %></td>
	<td><%=order1.getCemail() %></td>
	<td><%=order1.getVid() %></td>
	<td><%=order1.getMid() %></td>
	<td><%=order1.getMname()%></td>
	
	<td><input type="submit" value="Send Email"/></td>

</tr>	
<% }%>

</table>
</form>
</body>
</html>