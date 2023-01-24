<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="user" class="com.anand.entity.User" scope="session"></jsp:useBean>
<%@ include file="cache_control_page.jsp"  %>

<%
   if(session==null || user.getName()==null){
	   response.sendRedirect("logout.jsp");
   }else{
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Add Form</title>
<style>

</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

		<%@ include file="admin_home_menu.jsp" %>

<form action="car_add.jsp" method="post">
<table align="center" border="2">
<thead >
<tr ><th colspan="2">Car Info</th></tr>
</thead>
<tbody>
<tr><td>Model No:</td><td><input type="text" name="model"></td></tr>
<tr><td>Price: </td><td><input type="text" name="price"></td></tr>
<tr><td>Color: </td><td><input type="text" name="color"></td></tr>
<tr><td>Registration Date:</td><td><input type="text" name="regDate"></td></tr>
<tr><td></td><td><input type="submit" value="Add"></td></tr>
</tbody>
</table>
</form>
</body>
</html>

<% } %>