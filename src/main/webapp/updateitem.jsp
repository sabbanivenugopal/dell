<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateitem" method= "post" >
<input type="hidden" name="version" value="${itemInfo.version}"/>
Item No:<input type="number" name="itemid" readonly="readonly" value="${itemInfo.itemid}"/></br>
Item:<input type="text" name="item" value="${itemInfo.item}"/></br>
Price:<input type="text" name="price" value="${itemInfo.price}"/></br>
Quantity:<input type="text" name="quantity" value="${itemInfo.quantity}"/></br>
Veg<input type="radio" name="typeof" ${veg} value="veg"></br>
Non-veg<input type="radio" name="typeof"  ${nonveg}  value="nonveg"></br>
<input type="submit" value = "Update"></br>
</form>
<a href="goToMenu">Click Here</a> to goto menu page..!!

</body>
</html>