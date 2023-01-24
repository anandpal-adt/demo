<%@page import="java.util.List"%>
<%@page import="com.anand.service.CarServiceImple"%>
<%@page import="com.anand.service.CarService"%>
<%@page import="com.anand.entity.Car"%>

<%@
    page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
    
    <jsp:useBean id="user" class="com.anand.entity.User" scope="session"></jsp:useBean>
<%@ include file="cache_control_page.jsp"  %>
    

<%
   if(session==null || user.getName()==null){
	   response.sendRedirect("logout.jsp");
   }else{
%>

<%
   CarService carService=new CarServiceImple();
   List<Car> carList=carService.getAll();
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car List</title>
<style >


</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
		<%@ include file="admin_home_menu.jsp" %>
	
		<table align="center" border="1"  >
			<thead>
				<tr id="b1"><th colspan="7" >Car List</th></tr>
				<tr>
					<th>MODEL</th>
					<th>PRICE</th>
					<th>COLOR</th>
					<th>REG. YEAR</th>
					<th>DELETE</th>
					<th>UPDATE</th>
					<th>IMAGE</th>
				</tr>
			</thead>
			<tbody>
				<%
					for(Car car : carList){
				%>
				<tr>
					<td><%=car.getModel()%> </td>
					<td><%=car.getPrice()%> </td>
					<td><%=car.getColor()%> </td>
					<td><%=car.getRegDate()%> </td>
					<td><a href="car_delete.jsp?carId=<%=car.getCarId()%>" >Delete</a></td>
					<td><a href="car_update_form.jsp?carId=<%=car.getCarId()%>" >Update</a></td>
					
					<td><a href="car_upload.jsp?carId=<%=car.getCarId()%>" >
					<img  src="<%= car.getImage()%>"  width="70"  height="70"  alt="no image" />
					</a></td>
					
					<td></td>
				</tr>
				
				<% } %>
			</tbody>
		</table>
	
</body>
</html>
<% }%>