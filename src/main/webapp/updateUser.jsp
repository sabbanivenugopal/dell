<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>This is update user page</h3>
${errorMessage}
<form action="updateUserPage" method= "post">
<input type ="hidden" name="version"  value="${userInfo.version}"/></br></br>
UserId: <input type ="number" name="userId" readonly="readonly" value="${userInfo.userId}"/></br></br>
Name: <input type ="text" name="userName"  value="${userInfo.userName}"/></br></br>
Email Id: <input type ="text" name="emailId" value="${userInfo.emailId}"/></br></br>
Mobile No:<input type="text" name="mobile" value="${userInfo.mobile}"/></br></br>
Password: <input type="text" name="password" value="${userInfo.password}"/></br></br>
City: <input type ="text" name="city" value="${userInfo.city}"/></br></br>
<input type ="submit" value="update"></br></br>
</form>
<a href="Home.jsp">Click Here</a> to goto menu page..!!
</body>
</html>