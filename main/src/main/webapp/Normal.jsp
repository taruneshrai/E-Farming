<%@page import="com.entities.User"%>
<% 
 User user = (User)session.getAttribute("current-user") ;  
 if(user ==null){ 
	 session.setAttribute("message", "your are not logged in") ;
	 response.sendRedirect("Login.jsp") ;
	 return ;
 } 

%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Normal user</title> 
<%@include file="components/common_css_js.jsp" %>
</head>
<body>
 <%@include file="components/navbar.jsp" %>  
</body>
</html>