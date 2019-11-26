<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function edituser(Id) {
		alert('edit button triggered..!!')
		document.forms[0].action = "${pageContext.request.contextPath}/edituser?userId="+Id;
		document.forms[0].method = "post";
		document.forms[0].submit();

	}
	function deleteuser(Id) {

		alert(name + ' delete button triggred!!')
		document.forms[0].action = "${pageContext.request.contextPath}/deleteuser?userId="+Id;
		document.forms[0].method = "post";
		document.forms[0].submit();

	}
</script>
</head>
<h2>Show User Register List</h2>
<body>
	<font color="red">${user}</font>
	</br>
	<form action="">
		<table border="1">
			<tr>
				<th>UserId</th>
				<th>UserName</th>
				<th>EmailId</th>
				<th>Mobile</th>
				<th>Password</th>
				<th>City</th>
			</tr>

			<c:forEach var="user" items="${userdetails}">
				<tr>
					<td>${user.userId}</td>
					<td>${user.userName}</td>
					<td>${user.emailId}</td>
					<td>${user.mobile}</td>
					<td>${user.password}</td>
					<td>${user.city}</td>
					<td><input type="button" onclick="edituser('${user.userId}')" value="Edit" /></td>
					<td><input type="button" onclick="deleteuser('${user.userId}')" value="Delete" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	</br>
	<a href="Home.jsp">Click Here</a> to goto menu page..!!
</body>
</html>