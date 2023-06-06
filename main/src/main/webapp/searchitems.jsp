<%@page import="java.io.PrintWriter"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Productdao"%>
<%@page import="com.entities.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search items</title>
</head>
<body>

<%@include file="components/common_css_js.jsp" %>
<%@include file="components/navbar.jsp" %>  

<% 
String query = request.getParameter("query") ;
Productdao pd = new Productdao(FactoryProvider.getFactory()) ; 
List<Product> pl = pd.getsearch(query) ; 
PrintWriter Out= response.getWriter() ; 
     
if(pl.isEmpty()){
	Out.print("no item found") ; 
} 
else{
%>
       <div class="container">
         
        <% 
           for(Product p : pl){
           %>  
            <div class="row"> 
          <div class="card allcard" style="width: 20rem; height:auto;">
  <img src="img/products/<%=p.getPPhoto()%>" class="card-img-top" style="max-height: 190px; width:auto; margin-top:5px;"alt="...">
  <div class="card-body">
    <h5 class="card-title text-center text-uppercase text-secondary"><%= p.getpName() %></h5>
    <p class="card-text text-center text-lowercase text-muted"><%=p.getpDesc() %></p>   
    
    <div class="container card-footer text-center">
    <a href="#" class="btn btn-dark text-success">&#8377;<%=p.getpricebydiscount()%>/-  &nbsp; <span class="text-secondary text-muted"><%= p.getpDiscount() %>%off &nbsp;&nbsp; <del>&#8377;<%=p.getpPrice()%></del>/-  </span></a>
     <div class="container text-center mt-1">
     <a href="#" class="btn btn-success"   onclick="addtocart(<%=p.getpId()%>,'<%=p.getpName()%>',<%=p.getpricebydiscount()%>) ;myFunction()">Add to Cart</a>
     <div id="snackbar">succesfully Added to cart</div>
     </div>
     </div>  
  </div>
</div>
  <br>  
</div> 
     <%} %>
        </div>  
        <%} %>
</body>
</html>