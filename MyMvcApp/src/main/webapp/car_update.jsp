<%@page import="com.anand.service.CarService"%>
<%@page import="com.anand.service.CarServiceImple"%>
<jsp:useBean id="car" class="com.anand.entity.Car"   scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="car"/>

<% 
CarService carService=new CarServiceImple();
carService.modify(car);
response.sendRedirect("car_list.jsp");

%>