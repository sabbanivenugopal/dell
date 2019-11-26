<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h2>Login Page</h2>
<body>
<font color= "red">${message}</font>
<form action="loginuser" method= "post">
userName: <input type="text" name = "emailId"></br></br>
Password: <input type="password" name = "password"></br></br>
<input type="submit" value="login"></br></br>
</form>
<a href="Home.jsp">Click Here</a> to goto menu page..!!
</body>
</html>