<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.main.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Menu</title>
</head>
<body>


<form method="post" action="AddMenu">
<input type = "button" size = 100 value = "LOGOUT" font = 40 align="right"></center>

<br>

<center><h1><b>ADD MENU</b></h1></center>
<center><img src="C:\Users\User\Desktop\EON\cust.png" width="140" height="160" alt="Natural"></center>

<br>
<center>

<b>Menu Name:</b>  <input type="text"     name="menuname"/><br><br>
<b>Price:</b>  <input type="text"     name="price"/><br><br>

<b>Vendor Name:</b>  <input type="text"     name="vendorname"/><br><br>

<input type="submit" value="ADD"/><br>
<br>
</form>
</center>
</body>
</html>