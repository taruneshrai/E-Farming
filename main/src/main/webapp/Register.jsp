<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title> 
<link rel="stylesheet" type="text/css" href="css\allcss.css" >
<%@include file="components/common_css_js.jsp" %>
</head>
<body id="registerbody">
 <a class="navbar-brand" href="index.jsp"><img src="img/farmlogo.jpg" alt="..." class="rounded-sm" style="height:60px; width: 80px ; margin: 5px 5px"></a>
     
  <%@include file="components/message.jsp" %>
  <br>
 <div class="row-mt5"> 
  <div class="col-md-4 offset-md-4"> 
 <form action="RegisterServlet" method="post"> 
  <div class="mb-3">
    <label class="name text-dark">Name</label>
    <input name="uname" type="text" class="form-control logininput1" id="Username">
  </div>
  <div class="mb-3">
    <label for="email" class="form-label text-dark">Email address</label>
    <input name="uemail" type="email" class="form-control logininput1" id="userEmail" aria-describedby="emailHelp">
  </div> 
  <div class="mb-3">
    <label for="password" class="form-label text-dark">Password</label>
    <input name="upassword" type="password" class="form-control logininput1" id="userPassword">
  </div>
  <div class="mb-3">
    <label for="phone" class="form-label text-white">Phone Number</label>
    <input name="uphone" type="text" class="form-control logininput1" id="userPhone">
  </div>
  <div class="mb-3">
    <label class="address text-white">Address</label>
    <textarea name="uaddress" class="form-control logininput1" id="UserAddress "></textarea>
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-outline-warning">Submit</button>
  <button type="reset" class="btn btn-outline-light">reset</button>
  </div>
</form> 
</div>
</div>
</body>
</html>