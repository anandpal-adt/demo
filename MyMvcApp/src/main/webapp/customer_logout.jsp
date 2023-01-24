<!-- Customer logout page -->


<%
	session.removeAttribute("customer");
	session.invalidate();
	response.sendRedirect("customer_login_form.jsp");
%>