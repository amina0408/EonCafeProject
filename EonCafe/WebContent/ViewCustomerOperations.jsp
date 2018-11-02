<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer operations</title>
</head>
<body>
 <br>
   
   <h1><center><b><font size =10 font color="red"></font>CUSTOMER OPERATIONS</b></font></center></h1><br>
		<br>
      <center><form method="post" action="AllMenuServletCustomer"><input type = "submit" size = 200 value = "View Menus" font = 40  height=140 width=180></form></center>
       <br>
       <center><form method="post" action="ViewCart.jsp"><input type = "submit" size = 100 value = "View your Cart" font = 40></form></center>
       <br>
       <form action="ViewCustomerLogin.jsp" method="post">
        <input type = "submit" size = 100 value = "LOGOUT" font = 40 align="right">
        </form>
       
      
</body>
</html>