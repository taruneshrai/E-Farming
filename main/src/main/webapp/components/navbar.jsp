<%@page import="com.entities.User"%>
<% 
      User user1 = (User)session.getAttribute("current-user") ;  
 %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><img src="img/farmlogo.jpg" alt="..." class="rounded-sm" style="height:60px; width: 80px"></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav justify-content-between w-100">
        <li class="nav-item">
          <a class="nav-link  me-2 " aria-current="page" href="about.jsp" >about</a>
        </li>
        <li>
         <form class="d-flex" method="post" action="searchitems.jsp">
        <input class="form-control me-2 ms-4 " type="search" name="query" placeholder="Search" aria-label="Search" style="width:700px;">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
        <li>
        <% 
           if(user1==null){
          %>
        <li class="nav-item">
          <a class="nav-link" href="Login.jsp">login</a>
        </li>
        <li class="nav-item ">
          <a class="nav-link " href="Register.jsp">Register</a>
        </li> 
        <% 
           } 
           else{
        	   %>
        	   
        	     <li class="nav-item d-flex">
        	   <span><img src="img/cartimg.jpg" alt="" style="height:40px;width:40px" data-bs-toggle="modal" data-bs-target="#cart-modal"></span>  
               <a class="nav-link "   href="#" data-bs-toggle="modal" data-bs-target="#cart-modal"><%=user1.getUserName() %><span class="ml-0 cart-items"><img alt="0" src=""></span></a>
             </li>    
        	   <li class="nav-item">
               <a class="nav-link me-2" href="LogoutServlet">logout</a>
             </li>  
             
           <%  
           }
         %> 
      </ul>
    </div>
  </div>
</nav>
</body>
</html>