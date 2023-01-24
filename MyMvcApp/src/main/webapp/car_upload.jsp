<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Upload</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>

	<%@ include file="admin_home_menu.jsp" %>

<form action="UploadServlet"   method="post"  enctype="multipart/form-data">
<input  type="hidden"  name="carId"   value="<%=request.getParameter("carId") %>"  />

<input type="file"  id="image" placeholder="Select Image"  name="image" > 	

<button type="submit">Upload</button>
</form>
</body>
</html>