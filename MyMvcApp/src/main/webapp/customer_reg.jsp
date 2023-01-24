<%@page import="com.anand.service.CustomerServiceImple"%>
<%@page import="com.anand.service.CustomerService"%>

<jsp:useBean  id="customer"  class="com.anand.entity.Customer"  ></jsp:useBean>
<jsp:setProperty property="*" name="customer"/>

<%

CustomerService customerService=new CustomerServiceImple();
   customerService.Cdetail(customer);
   response.sendRedirect("customer_login_form.jsp");
%>