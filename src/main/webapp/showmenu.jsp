<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function edititem(id){
	alert(id +'edit button triggered..!!')
	document.forms[0].action="${pageContext.request.contextPath}/edititem?itemid="+id;
	document.forms[0].method="post";
	document.forms[0].submit();	
	
}
function deleteitem(id){
	
	alert(id + ' delete button triggred!!')
	document.forms[0].action="${pageContext.request.contextPath}/deleteitem?itemid="+id;
	document.forms[0].method="post";
	document.forms[0].submit();	
	
}


</script>
</head>
<h2>Show Menu List</h2>
<body>
<form action="">
<table border="1">
<tr>
<th>ItemID</th>
<th>Item</th>
<th>price</th>
<th>quantity</th>
<th>veg/nonveg</th>
<th>Select</th>
</tr>
${message}
<c:forEach var="item" items="${menu}">
<tr>
<td>${item.itemid}</td>
<td>${item.item}</td> 
<td>${item.price}</td>
<td>${item.quantity}</td>
<td>${item.typeof}</td>
<td><input type="submit" onclick="edititem('${item.itemid}')"  value="Edit"/></td>
<td><input type="submit" onclick="deleteitem('${item.itemid}')" value="Delete"/></td>

</tr>
</c:forEach>
</table>
</br>

</form>
<a href="Home.jsp">Click Here</a> to goto menu page..!!
</body>
</html>