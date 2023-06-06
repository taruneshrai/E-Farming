<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <% String message = (String)session.getAttribute("message") ; 
     if(message !=null){
    	// out.println(message) ;
    %>  
      <div class="alert alert-success" role="alert">
    <%=message%> <a href="Login.jsp" class="alert-link"></a>
</div>
    	 
   <%  	 
     }
      session.removeAttribute("message") ;
    %>
</body>
</html>