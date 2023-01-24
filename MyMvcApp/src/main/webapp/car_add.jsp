<%@page import="com.anand.service.CarService"%>
<%@page import="com.anand.service.CarServiceImple"%>

<jsp:useBean id="car" class="com.anand.entity.Car"></jsp:useBean>
<jsp:setProperty property="*" name="car"/>
<% 
CarService carService=new CarServiceImple();
carService.add(car);
response.sendRedirect("car_add_form.jsp");
%>