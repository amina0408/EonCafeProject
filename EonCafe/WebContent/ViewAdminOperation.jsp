<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADMIN OPERATIONS</title>
</head>
<body>
 <br>
 <form action="ViewAdminLogin.jsp" method="post">
    <input type = "submit" size = 100 value = "LOGOUT" font = 40 align="right"></center></form>
   <h1><center><b><font size =10 font color="red"></font>ADMIN PAGE</b></font></center></h1><br>
		<br>
      <center><form method="post" action="ViewAddVendor.jsp"><input type = "submit" size = 200 value = "ADD VENDOR" font = 40  height=140 width=180></form></center>
       <br>
     <!--    <center><form method="post" action="ViewRemoveVendor.jsp"><input type = "submit" size = 100 value = "REMOVE VENDOR" font = 40></form></center>-->
       <br>
     <!--   <center><form method="post" action="AllOrdersServlet"><input type = "submit" size = 100 value = "VIEW ALL ORDERS" font = 40></form></center>-->
        <br>
         <br>
      <center><form method="post" action="AllVendorsServlet"><input type = "submit" size = 100 value = "VIEW ALL VENDOR'S" font = 40></form></center>
        <br>
        <br>
         <center><form method="post" action="AllCustomerServlet"><input type = "submit" size = 100 value = "VIEW ALL CUSTOMERS" font = 40></form></center>-->
        <br>
       <br>
      <center><form method="post" action="ViewAddCustomer.jsp"><input type = "submit" size = 100 value = "ADD CUSTOMER" font = 40></form></center>
		<br>
     <br>
        <center>  <form action="ViewAdminLogin.jsp" method="post"><input type="submit" value="LOGOUT" /></form></center>

</body>
</html>