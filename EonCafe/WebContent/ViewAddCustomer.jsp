<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form  action="AddCustomerServlet" method="post">
		<h1>Add Customer</h1>
		<h2>Enter Customer Details</h2>

		Customer ID <input type="text" name="cid" /><br>
		<br> Customer Name <input type="text" name="cname" /><br>
		<br> Customer email <input type="text" name="cemail" /><br>
		<br> Customer password <input type="password" name="cpassword" /><br>
		<br> <input type="submit" value="Add Customer" align="right">
	</form>
<form action="ViewAdminLogin.jsp" method="post">
	<input type="submit" value="LOGOUT" />
	</form>




</body>
</html>