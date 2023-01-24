<%@page import="com.anand.entity.Car"%>
<%@page import="com.anand.service.CarService"%>
<%@page import="com.anand.service.CarServiceImple" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
String s=request.getParameter("carId");
int carId=Integer.parseInt(s);
CarService carService=new CarServiceImple();
Car car=carService.get(carId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car update form</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<%@ include file="admin_home_menu.jsp" %>

<form action="car_update.jsp" method="post">
<input type="hidden" name="carId" value="<%=car.getCarId()%>" />
<table align="center" border="2">
<thead>
<tr id="b1"><th colspan="2">Car Update form</th></tr>
</thead>
<tbody>
<tr><td>Model No:</td><td><input type="text" name="model" value="<%=car.getModel()%>" > </td></tr>
<tr><td>Price: </td><td><input type="text" name="price" value="<%=car.getPrice()%>" > </td></tr>
<tr><td>Color: </td><td><input type="text" name="color"  value="<%=car.getColor()%>" > </td></tr>
<tr><td>Registration Date:</td><td><input type="text" name="regDate" value="<%=car.getRegDate()%>" > </td></tr>
<tr><td></td><td><input type="submit" value="Update"></td></tr>
</tbody>
</table>
</form>

</body>
</html>