<!-- Admin logout page -->
<%
	session.removeAttribute("user");
	session.invalidate();
	response.sendRedirect("login_form.jsp");
%>
