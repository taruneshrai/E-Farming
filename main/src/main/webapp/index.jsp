 
    <% Categorydao cdao = new Categorydao(FactoryProvider.getFactory());  
      List<Category> clist = cdao.getcategories() ;
     %> 
 
  


  

<%@page import="com.entities.Category"%>
<%@page import="com.dao.Categorydao"%>
<%@page import="com.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Productdao"%>
<%@page import="com.helper.FactoryProvider"%>
<html> 

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >

<title>FarmProduct-Home</title>
 <link rel="stylesheet" type="text/css" href="css\allcss.css" >
 <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body> 
<%@include file="components/common_css_js.jsp" %>
<%@include file="components/navbar.jsp" %> 
<h2 class="text-center"> 
       
  <small class="text-muted">FarmProducts.com</small>
</h2>
<br> 
<div>
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="img/farmproduct2.jfif" class="d-block w-100 h-50" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>First slide label</h5>
        <p>Some representative placeholder content for the first slide.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="img/farmproduct1.jpg" class="d-block w-100 h-50" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Second slide label</h5>
        <p>Some representative placeholder content for the second slide.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="img/farmproduct3.jfif" class="d-block w-100 h-50" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>Third slide label</h5>
        <p>Some representative placeholder content for the third slide.</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</div>
<br>
<div class="container">
<div class="row"> 
   
    <!--show catgory -->  
  
     <ul class="list-group list-group-horizontal-xl bg-dark ">
   <li class="list-group-item bg-dark"><a href="index.jsp?cat=all" class="list-group-item list-group-item-action  bg-light font-weight-bold"  aria-current="true">
     ALL Products
  </a></li> 
   <% 
        for(Category category:clist){
        	%> 
        	<li class="list-group-item bg-dark "><a href="index.jsp?cat=<%=category.getCategoryId()%>" class="list-group-item list-group-item-action "><%= category.getCategoryTitle() %></a>
        	</li><%
        }
       %>  
       <% 
       Productdao pdao = new Productdao(FactoryProvider.getFactory()); 
       List<Product> list = null; 
       String cat = request.getParameter("cat") ;
       if(cat==null){
    	   list = pdao.getallproducts() ; 
       }
       else if(cat.trim().equals("all")){
    		   list = pdao.getallproducts() ;  
       }
       else{
    	    int ciid = Integer.parseInt(cat.trim()) ;
    	     list = pdao.getproductbyCategoryID(ciid) ;    
       }
       
    %>
      
</ul> 
 </div> 
 <br>
     <!--show products --> 

       <div class="row">
         
        <% 
           for(Product p : list){
           %>  
            <div class="col-md-4"> 
          <div class="card allcard" style="width: 20rem; height:auto;">
  <img src="img/products/<%=p.getPPhoto()%>" class="card-img-top" style="max-height: 190px; width:auto; margin-top:5px;"alt="...">
  <div class="card-body">
    <h5 class="card-title text-center text-uppercase text-secondary"><%= p.getpName() %></h5>
    <p class="card-text text-center text-lowercase text-muted"><%=p.getpDesc() %></p>   
    
    <div class="container card-footer text-center">
    <a href="#" class="btn btn-dark text-warning">&#8377;<%=p.getpricebydiscount()%>/-  &nbsp; <span class="text-danger text-danger"><%= p.getpDiscount() %>%off &nbsp;&nbsp; <del>&#8377;<%=p.getpPrice()%></del>/-  </span></a>
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
    
 </div> 

 <%@include file="common_modal.jsp"%>
 <script type="text/javascript">
 function myFunction() {
   var x = document.getElementById("snackbar");
   x.className = "show";
   setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
 } 

 </script>
</body>
</html>
