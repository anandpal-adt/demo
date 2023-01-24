<%@page import="com.anand.service.CarServiceImple"%>
<%@page import="com.anand.service.CarService"%>
<%
String p=request.getParameter("carId");
int carId=Integer.parseInt(p);
CarService carService=new CarServiceImple();
carService.remove(carId);
response.sendRedirect("car_list.jsp");
%>