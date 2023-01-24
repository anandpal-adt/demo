<%@page import="com.anand.entity.Car"%>
<%@page import="com.anand.service.CustomerServiceImple"%>
<%@page import="com.anand.service.CustomerService"%>
<%@page import="com.anand.entity.Customer"%>
<%@page import="com.anand.entity. User"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="user" class="com.anand.entity.User" scope="session"  ></jsp:useBean>
    
    <%@ include file="cache_control_page.jsp" %>
    
    <%
    	if(session==null || user.getName()==null){
    		response.sendRedirect("logout.jsp");
    	}else{
    
    %>
    <%
    CustomerService customerService=new CustomerServiceImple();
    List<Customer> carList=customerService.getCdetails();
    Car car=new Car();
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Interest List</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<%@ include file="admin_home_menu.jsp" %>
	<div class="container-fluid mt-3">
	
		<h2>Interest List</h2>
              
  <table class="table table-striped">
			<thead>
				
				<tr>
					<th>Serial no</th>
					<th>Contact/Mail Id</th>	
					<th>Liked car id</th>				
				</tr>
			</thead>
			<tbody>
			<%
					for(Customer customer : carList){
				%>
				<tr>
					<td><%=customer.getCustomerId()%></td>
					<td><%=customer.getCustomerName()%></td>	
    			   <td><%=customer.getCustomerLike() %></td>	    			
			     </tr>
			<%} %>
			</tbody>
		</table>
	</div>
</body>
</html>

<% } %>