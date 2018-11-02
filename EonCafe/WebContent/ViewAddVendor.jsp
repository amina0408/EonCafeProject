<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Vendor</title>
</head>
<body>

<center><h1><b>ADD VENDOR</b></h1></center>
<center><img src="C:\Users\Administrator\Desktop\EON\12.png" width="140" height="160" alt="Natural"></center>

<br>
<br>
<center>
<form method="post" action="AddVendorServlet">
<b>Enter Vendor Id:</b> <input type="text"     name="Vendor id"/><br><br>
<b>Enter Vendor Name:</b>  <input type="text"     name="Vendor name"/><br><br>
<b>Enter Vendor Email:</b> <input type="text"   name="email"/><br><br>
<b>	Enter Vendor Password:</b><input type="password" name="password">
<br>
<input type="submit" value="Submit"/>
</form>
<form action="ViewAdminLogin.jsp" method="post">
<input type="submit" value="LOGOUT"/>
</form>
</center>

</body>
</html>