<%@page import="com.model.Menu"%>
<%@page import="com.dao.MenuDaoImpl"%>
<%@page import="com.dao.MenuDao"%>
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

<form method="post" action="CartOrderServlet">


<%
	
	
	Object attr = request.getAttribute("menuList");
			List<Menu> menuList1 = (List<Menu>) attr;


%>



<table border=2>
<tr>
<td> MenuId </td>
<td> VendorId </td>
<td> Menu Name</td>
<td> Menu Price</td>
<td> Vendor Name </td>
</tr>

	
<%
			for (int i=0;i<menuList1.size();i++)
			{
		%>
		<tr>
			<td><%=menuList1.get(i).getMid() %></td>
			<td><%=menuList1.get(i).getVid() %></td>
			<td><%=menuList1.get(i).getMname() %></td>
			<td><%=menuList1.get(i).getMprice() %></td>
			<td><%=menuList1.get(i).getVname() %></td>
			<%
			String quantity="quantity";
			String value=Integer.toString(i);
			String quantity1;
			quantity1=quantity+value;%>
			<td><select name="quantity1" onchange="">
			<option selected="true" disabled="disabled">Q</option> 
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				</select>  <td>    
			<!--  <td><input type="submit" value="Add to cart"/></td>-->
			<th><input type="checkbox" name="checkboxgroup" value="<%=menuList1.get(i).getMid() %>"/></th>
			
		</tr>

		<%
			}
		%>
<input type="submit" name="action" value="Add_items_to_cart"/>

<input type="submit" name="action" value="Order"/>
</form>

<!--  <form method="post" action="OrderByCustomer">-->


</form>
</body>
</html>