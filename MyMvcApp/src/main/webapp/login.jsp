<%@page import="com.anand.service.UserServiceImple"%>
<%@page import="com.anand.service.UserService"%>
<jsp:useBean id="user" class="com.anand.entity.User" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

<%
UserService userService=new UserServiceImple();
    boolean b=userService.login(user);
      if(b)
          response.sendRedirect("interest_list.jsp");
      else
         response.sendRedirect("login_form.jsp");

%> 