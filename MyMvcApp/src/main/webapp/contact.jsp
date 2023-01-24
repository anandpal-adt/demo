<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1{
    text-align: center;
    align-items: center;

}
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=tel], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

input[type=button]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
#subject {
  float: left;
  width: 100%;
  margin-top: 6px;
}
</style>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<h1>Fill The Details Below So we can contact you as soon as possible!!</h1>

<div>
  <form action="" id="userInput" target="refresh" >
    <label for="fname">Full Name</label>
    <input type="text" id="fname" name="firstname" placeholder="Your full name.." required>

    <label for="number">Contact</label>
    <input type="tel" id="number" name="number" placeholder="Your Contact number.." required><br>

    <label for="country">Your Country</label>
    <select id="country" name="country">
      <option value="australia">Australia</option>
      <option value="canada">Canada</option>
      <option value="usa">USA</option>
      <option value="India">India</option>
      <option value="London">London</option>
      <option value="Russia">Russia</option>
      <option value="Switzerland">Switzerland</option>
    </select>
      <textarea id="subject" name="subject" placeholder="Comment/Message......."  style="height:200px" required></textarea>
  
    <input type="submit" onclick="alert('your data has been submitted successfully')"  value="Submit">
  <input type="button" value="Go back!" onclick="history.back()">
  </form>
</div>
<script>

</script>
</body>
</html>
