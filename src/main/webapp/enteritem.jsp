<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h2>Item Add To Menu List</h2>
<body>
<font color="Green">${msg}</font>
<form action="addtomenu" method= "post">
Item No:<input type="number" name="itemid"/></br>
Item:<input type="text" name="item"/></br>
Price:<input type="text" name="price"/></br>
Quantity:<input type="text" name="quantity"/></br>
Veg<input type="radio" name="typeof"  value="veg"></br>
Non-veg<input type="radio" name="typeof" value="nonveg"></br>
<input type="submit" value = "ADD"></br>
</form>
<a href="Home.jsp">Click Here</a> to goto menu page..!!
</body>
</html>