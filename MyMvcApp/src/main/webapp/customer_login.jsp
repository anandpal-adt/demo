<%@page import="javax.websocket.Session"%>
<%@page import="com.anand.entity.Car"%>
<%@page import="com.anand.service.CustomerServiceImple"%>
<%@page import="com.anand.service.CustomerService"%> 
<jsp:useBean  id="customer"  class="com.anand.entity.Customer"  scope="session"></jsp:useBean>
<jsp:setProperty property="*"  name="customer" />

<%
CustomerService customerService=new CustomerServiceImple();
    boolean b=customerService.Clogin(customer);
   if(b){
    customerService.Clikes(customer);
    
    String username = (String)request.getSession(true).getAttribute("customerName"); 
    session.setAttribute("customerName",username);
 
    response.sendRedirect("home.jsp");
   }
      else
      response.sendRedirect("customer_login_form.jsp");

%>
