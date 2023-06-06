

$( document ).ready(function() {
    console.log( "ready!" );
     updateCart() ;
}); 

function addtocart(pid,pname,price)
{ 
      
  let cart =  localStorage.getItem("cart") ;  
  
   if(cart==null){
       let products= []; 
       let product={ProductId:pid,ProductName:pname,ProductQuantity:1,productPrice:price} ;
       products.push(product) ;  
       localStorage.setItem("cart",JSON.stringify(products)); 
       console.log("first time")
    } 
    else{
          let pcart = JSON.parse(cart) ;
         let oldProduct =  pcart.find((item) => item.ProductId == pid) ;  
           if(oldProduct){
             console.log("already added") ;
             }
         else{
          
            let product={ProductId:pid,ProductName:pname,ProductQuantity:1,productPrice:price} ;
            //add product  
            pcart.push(product) ; 
            localStorage.setItem("cart",JSON.stringify(pcart)); 
            console.log("new product added")
         }  
           
       
     } 
     updateCart();
 }
 
//update cart    
 
function updateCart(){ 
     const cartitem = document.querySelector(".cart-items"); 
      const cartbody = document.querySelector(".cart-body"); 
       const checkoutbtn = document.querySelector(".checkout-btn"); 
      
  let cartStr =  localStorage.getItem("cart") ;
   let cart = JSON.parse(cartStr) ; 
   if(cart==null||cart.length==0){
     console.log("cart is empty") ; 
      cartitem.innerHTML ="(0)" ;
      cartbody.innerHTML = "cart is empty";
       checkoutbtn.classList.add("disabled") ; 
    } 
     
    else{ 
            
            console.log("cart") ;
           cartitem.innerHTML = `(${cart.length})` ;
           let table = `
             <table class="table">
  <thead>
    <tr>
      <th scope="col">Item</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
      <th scope="col">Total Price</th>
       <th scope="col">&nbsp;Action</th> 
       <th scope="col"></th>
      <th scopr="col"</th>
    </tr>
  </thead>`
  let total_price = 0 ;
  cart.map((item)=>{ 
   table = table +`  
    <tr> 
      <th scope="row">${item.ProductName}</th>
      <td>&#8377;${item.productPrice}</td>
      <td>${item.ProductQuantity}</td>
      <td>&#8377;${item.ProductQuantity*item.productPrice}</td>
      <td><button onclick="decreaseQuantity(${item.ProductId})" class="btn btn-danger btn-sm">-</button></td>
      <td><button onclick="increaseQuantity(${item.ProductId})" class="btn btn-success btn-sm">+</button></td>
    </tr>` 
        total_price += item.productPrice*item.ProductQuantity ;
    } ); 
    
    table += `<tr><td class="text-center font-weight-bold">Total Price:&#8377;${total_price}</td></tr></tbody></table>`
    
        cartbody.innerHTML = table ;   
           checkoutbtn.classList.remove("disabled") ; 
     }
}
 
 //delete item
function decreaseQuantity(pid){ 
  let cart  =  JSON.parse(localStorage.getItem("cart")) ; 
  
   let Product =  cart.find((item) => item.ProductId == pid) ;    
    
      if(Product.ProductQuantity == 1){
           let newcart =  cart.filter((item)=>item.ProductId!=pid)
 
            localStorage.setItem("cart",JSON.stringify(newcart)) ; 
            updateCart()   
       }
      else { 
     Product.ProductQuantity =  Product.ProductQuantity - 1 ;
         
              cart.map((item)=>{
                if(item.ProductID==pid){
                  item.ProductQuantity = Product.productQuantity
                 }
               }) ; 
           localStorage.setItem("cart",JSON.stringify(cart)); 
                console.log("decreased quantity")   
                updateCart();  
                }


}

 function increaseQuantity(pid){
    let cart  =  JSON.parse(localStorage.getItem("cart")) ; 
     let Product =  cart.find((item) => item.ProductId == pid) ;    
     Product.ProductQuantity =  Product.ProductQuantity + 1 ;
         
              cart.map((item)=>{
                if(item.ProductID==pid){
                  item.ProductQuantity = Product.productQuantity
                 }
               }) ; 
           localStorage.setItem("cart",JSON.stringify(cart)); 
                console.log("increased quantity") 
              updateCart();                
 }

  
  
        
