<%@page import="com.anand.entity.Customer"%>
<%@page import="com.anand.entity.Car"%>
<%@page import="java.util.List"%>
<%@page import="com.anand.service.CarServiceImple"%>
<%@page import="com.anand.service.CarService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<style >
*{
margin:0;
}

h1{
    color: rgb(4 8 10);
    text-align: center;
    text-shadow: 2px 2px white;
}




table.table{
font-weight: bolder;
margin-top: 23px;
}
thead{
font-family: sans-serif;
font-size: large;
color:white;
}

footer {
  display: block;
  align-items: center;
  text-align: center;
  padding: 15px;

  color: aliceblue;
  background-color: rgb(5, 5, 5);
}

table{ width:100%; }

* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
   width: 100%;
  position: relative;
  margin: auto;
  height: 600px;
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

.text2 {
  color: white;
  font:bolder;
  font-size: 45px;
  padding: 12px 22px;
  position: absolute;
   top:10px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  animation-name: fade;
  animation-duration: 1.5s;
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}





</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

<jsp:useBean id="user" class="com.anand.entity.User"></jsp:useBean>
<%@ include file="cache_control_page.jsp"  %>

<%
   CarService carService=new CarServiceImple();
   List<Car> carList=carService.getAll();
   %>

</head>
<body >
     	<%@ include file="home_navbar.jsp" %>
<div id="home"  >
	
<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
    <div class="text2">Welcome to My Website</div>
  <img src="https://wallpaperaccess.com/full/33117.jpg" width=100% height=670px>
  <div class="text">Caption Text</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
    <div class="text2">Welcome to My Website</div>
  <img src="https://wallpaperaccess.com/full/33115.jpg" width=100% height=670px>
  <div class="text">Caption Two</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
    <div class="text2">Welcome to My Website</div>
  <img src="https://wallpaperaccess.com/full/33116.jpg" width=100% height=670px>
  <div class="text">Caption Three</div>
</div>


</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>




</div>
<div class="container -fluid">
<div class="table-responsive">
<table border="5px" class="table table-striped   table table-hover  table " >
			<thead >
				<tr align="center"   bgcolor="grey" >
				<th colspan="7" >Car List</th>
				</tr>
				<tr align="center"  bgcolor="red">
					<th  id="b">Model</th>
					<th>Price</th>
					<th>Color</th>
					<th>Reg. Year</th>
					<th>Images</th>
			        <th>Interest</th>	
			        <th>Buy Now!</th>	
				</tr>
			</thead>
			<tbody >
				<%
					for(Car car : carList){
				%>
				<tr align="center" >
					<td><%=car.getModel()%></td>
					<td><%=car.getPrice()%></td>
					<td><%=car.getColor()%></td>
					<td><%=car.getRegDate()%></td>
					<td><img  src="<%= car.getImage()%>"  width="150"  height="100"  alt="no image"  border="3px"   />
                    <td><a href="customer_login.jsp?customerLike=<%=car.getCarId()%>" >Like</a></td>
 				    <td><a href="customer_buy.jsp"><button type="button" class="btn btn-warning">Buy</button></a></td>
 					</tr>
				<% } %>
			</tbody>
		</table>
</div>
</div>
<footer>
All right reserved  &copy; 2022   Made by Anand Rajput
</footer>
<script>
let slideIndex = 0;
showSlides();

function showSlides() {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  let dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 1500); // Change image every 2 seconds
}
</script>

</body>
</html>