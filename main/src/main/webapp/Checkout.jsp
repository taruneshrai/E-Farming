
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 <%@include file="components/common_css_js.jsp" %>
</head>
<body> 

 <%@include file="components/navbar.jsp" %> 
  
  <div class="container">
   <div class="row mt-4"> 
     <div class="col-md-6">
      <div class="card">
         <div class="card-body">
         <h3 class="text-center bold">your cart</h3>
           <div class="cart-body">
           </div>  
       </div>
      </div>
      </div>
      <div class="col-md-6">
       <div class="card">
         <div class="card-body">
         <h3 class="text-center bold">Your details</h3>
            <form Action="Order.jsp">
  <div class="form-group mt-1">
    <label for="exampleFormControlInput1">Email address</label>
    <input type="email" value="<%=user.getUserEmail()%>"class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
  </div>
   <div class="form-group mt-1">
    <label for="name">Shipping name</label>
    <input type="text" value="<%=user.getUserName() %>" class="form-control" id="name">
  </div>
  <div class="form-group mt-1">
    <label for="name">contact</label>
    <input type="text" value="<%=user.getUserPhone()%>" class="form-control" id="name">
  </div>
  <div class="form-group mt-1">
    <label for="exampleFormControlTextarea1">Address</label>
    <textarea class="form-control" value="<%=user.getUserAddress()%>"id="exampleFormControlTextarea1" rows="3"></textarea>
  </div>
  
   <div class="container text-center mt-2"> 
   <a href="index.jsp"><button type="button" class="btn btn-secondary">Continue Shopping</button></a>
  <button type="submit" class="btn btn-success" onclick="showTableData()">OrderNow</button>
  
  </div>
   
</form>
       </div>
      </div>
      </div>
    </div>
  </div> 

  <script src="js/app.js"></script>
   <script>   
    function showTableData() {
      
        var  Tab = document.querySelector(".cart-body");;
         var x = [] ;
           var myTab = Tab.children[0] ; 
           <%! List<String> s = new ArrayList<String>();%> 
        // LOOP THROUGH EACH ROW OF THE TABLE AFTER HEADER.
        for (i = 1; i < myTab.rows.length-1; i++) {

            // GET THE CELLS COLLECTION OF THE CURRENT ROW.
            var objCells = myTab.rows.item(i).cells;

            // LOOP THROUGH EACH CELL OF THE CURENT ROW TO READ CELL VALUES.
           
            for (var j = 0; j < 1; j++) { 
            	
            	   x.push(objCells.item(j).innerHTML) ; 
            	    console.log(objCells.item(j).innerHTML) ;
            }
        } 
        
        var json=x;
        $.ajax({
            url:"PostorderServlet",
            type:"POST",
            dataType:'json',
            data: {json:json},
            success:function(data){
                // codes....
            },
        });  
          
    }
             
  </script>
  <%@include file="common_modal.jsp"%>
</body>
</html>