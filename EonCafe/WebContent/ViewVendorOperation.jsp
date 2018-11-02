<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vendor Operation</title>
</head>
<body>

<input type = "button" size = 100 value = "LOGOUT" font = 40 align="right"></center>
   <h1>
   
   <center><b><font size =10 font color="red"></font>VENDOR PAGE</b></font></center></h1><br>
		<br>
		<form  method="post" action="ViewAddMenu.jsp" >
      <center><input type = "submit" size = 200 value = "ADD MENU" font = 40  ></center>
       <br>
       </form>
       <br>
       <form  method="post" action="ViewUpdateMenu.jsp" >
       <center><input type = "submit" size = 100 value = "UPDATE MENU" font = 40></center>
       <br>
       </form>
       <br>
       <form  method="post" action="OrderDisplayByVendorId" >
      <center><input type = "submit" size = 100 value = "VIEW ORDER" font = 40></center>
        </form>
	    <!--  <center><a href="OrderDisplayByVendorId">View Order</a></center>-->
</body>
</html>