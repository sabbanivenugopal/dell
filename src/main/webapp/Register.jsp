<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h2>Register Page</h2>
<body>
<font color="red">${message}</font>
<form action="userregister" method= "post">
User Id: <input type ="text" name="userId"></br></br>
Name: <input type ="text" name="userName"></br></br>
Email Id: <input type ="text" name="emailId"></br></br>
Mobile No:<input type="text" name="mobile"></br></br>
Password: <input type="password" name="password"></br></br>
City: <input type ="text" name="city"></br></br>
<input type ="submit" value="Register"></br></br>
</form>
<a href ="Login.jsp"><span color="red">click here</span></a>for login..!!</br></br>

<form action="testIoc">

<input type="submit" value="testIoc"/>
</form>

</body>
</html>