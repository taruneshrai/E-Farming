<%@page import="com.dao.Userdao"%>
<%@page import="com.entities.Product"%>
<%@page import="com.dao.Productdao"%>
<%@page import="com.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.Categorydao"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="com.entities.User"%> 


 <% 
               Categorydao cdao = new Categorydao(FactoryProvider.getFactory()) ; 
                 List<Category> list=  cdao.getcategories() ; 
                Productdao pdao = new Productdao(FactoryProvider.getFactory()); 
                  long pcount = pdao.getProductcount() ;
                  Userdao udao = new Userdao(FactoryProvider.getFactory()); 
                  long ucount = udao.getUsercount();
            %>
            
<% 
 User user = (User)session.getAttribute("current-user") ;  
 if(user ==null){ 
	 session.setAttribute("message", "your are not logged in") ;
	 response.sendRedirect("Login.jsp") ;
	 return ;
 } 
 else{
	 if(user.getUserType().equals("normal")){
		 session.setAttribute("message", "your are not admin") ;
		 response.sendRedirect("Login.jsp") ;
		 return ;
	 }
 }
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin panel</title>
 <link rel="stylesheet" type="text/css" href="css\allcss.css" >
<%@include file="components/common_css_js.jsp" %> 
<link href="css/style.css" rel="stylesheet">  
</head>
<body id="body">
 <%@include file="components/navbar.jsp" %>  
 <br><br>
 <%@include file="components/message.jsp" %>  
 <div class="container">
  <div class="row">
    <div class="col-md-5"> 
    <img style="max-width: 125px;" class="img-fluid" src="img/team.png" class="img-thumbnail" alt="...">
      <h2 class="text=muted text-info bg-light"><%=ucount %></h2>
    </div>
    <div class="col-md-5"> 
    <img style="max-width: 125px;" class="img-fluid" src="img/product.png" class="img-thumbnail" alt="...">
       <h2 class="text=muted text-info bg-light"><%= list.size() %></h2>
    </div>
    <div class="col-md-2"> 
    <img style="max-width: 125px;" class="img-fluid" src="img/package.png" class="img-thumbnail" alt="...">
       <h2 class="text=muted text-info bg-light"><%= pcount%></h2>
    </div>
  </div> 
</div>  
<br><br>
<div class="container  ">
  <div class="row">
    <div class="col-md-10"> 
    <img style="max-width: 150px;" src="img/add-to-basket.png" class="img-thumbnail" data-bs-toggle="modal" data-bs-target="#exampleModal"   alt="...">
      <h4 class="text=muted text-info bg-light">+Category</h4>
    </div>
    <div class="col-md-2">
    <img style="max-width: 150px;"  src="img/add-to-cart.png" class="img-thumbnail" data-bs-toggle="modal" data-bs-target="#exampleModal1" alt="...">
      <h4 class="text=muted text-info bg-light">+Product</h4> 
    </div>
  </div>
 </div> 
 
 
 
<!-- Modal category -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">fill category detail</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
         <form action="ProductOperationServlet" method="post"> 
           <div class="from-group mt-2">   
           <input type="hidden" name="operation" value="addcategory">
           <input  name="categoryTitle" type="text" class="form-control" placeholder="Enter category title" required />
           </div>
            <div class="from-group mt-2">  
           <textarea  name="categoryDesc" class="form-control" placeholder="Enter category description" required></textarea>
           </div>
           <div class="container text-center mt-2">
            <button class="btn btn-outline-success">Add category</button>
           </div>
         </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
 <!-- model closed --> 
  
 <!-- modal product --> 
 <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">fill product detail</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
         <form action="ProductOperationServlet" method="post" enctype="multipart/form-data"> 
           <div class="from-group"> 
           <input type="hidden" name="operation" value="addproduct"> 
           <input  name="productName" type="text" class="form-control" placeholder="Enter product name" required />
           </div>
           <div class="from-group mt-2">  
           <input  name="productPrice" type="text" class="form-control" placeholder="Enter product price" required />
           </div>
           <div class="from-group mt-2">  
           <input  name="productDiscount" type="text" class="form-control" placeholder="Enter product discount" required />
           </div>
            <div class="from-group mt-2">  
           <input  name="productQuantity" type="text" class="form-control" placeholder="Enter product Quantity" required />
           </div>
          
            <div class="from-group mt-2">  
             <select name="catId" class="form-control" id="">
             <% 
                for(Category c:list){
             %>
             <option value="<%= c.getCategoryId() %>"><%= c.getCategoryTitle() %></option> 
             <% }
               %>
             </select>
           </div>
            <div class="from-group mt-2">  
           <textarea  name="productDesc" class="form-control" placeholder="Enter product description" required></textarea>
           </div> 
             <div class="from-group mt-2">   
           <label for="pid">Select picture of product</label> 
           <input type="file" name="productPic" id="pid" required />
           </div>
           <br>
           <div class="container text-center"> 
            <button class="btn btn-outline-success">Add product</button>
           </div>
         </form>
      </div>
    </div>
  </div>
</div>
 
 <!-- model closed --> 
</body>
</html>