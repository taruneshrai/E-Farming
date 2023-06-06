package com.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.Categorydao;
import com.dao.Productdao;
import com.entities.Category;
import com.entities.Product;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class ProductOperationServlet
 */

@MultipartConfig  //for meadia files in the form
public class ProductOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductOperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     
		String op = request.getParameter("operation") ;
		
		//fetching category data 	 
		if(op.trim().equals("addcategory")) {
		String cTitle =request.getParameter("categoryTitle"); 
		String cDesc =request.getParameter("categoryDesc"); 
		
		Category category = new Category(cTitle,cDesc); 
		
		//save  ;
		Categorydao cdao = new Categorydao(FactoryProvider.getFactory());  
		 int cid = cdao.saveCategory(category) ;
		   PrintWriter out = response.getWriter() ;  
		   HttpSession httpsession = request.getSession() ; 
		   httpsession.setAttribute("message", "category saved sucessfully with id "+cid);
		     response.sendRedirect("Admin.jsp"); 
		     return ;
		} 
		else if(op.trim().equals("addproduct")) {
			//add product  
			String pname =request.getParameter("productName");
			
			String pprice =request.getParameter("productPrice"); 
			
			int Price = Integer.parseInt(pprice) ;
			
			String pdesc =request.getParameter("productDesc"); 
			
			String pdiscount =request.getParameter("productDiscount");	
			int discount = Integer.parseInt(pdiscount) ; 
			
			
			String pquantity =request.getParameter("productQuantity"); 	
			int quantity = Integer.parseInt(pquantity) ; 
			
			String catId =request.getParameter("catId"); 
			int cid = Integer.parseInt(catId) ; 
			
			Part part = request.getPart("productPic") ;  
			
			Product p = new Product() ; 
			p.setpName(pname); 
			p.setpPrice(Price);  
			p.setpDesc(pdesc);
			p.setpDiscount(discount); 
			p.setpQuantity(quantity); 
			p.setPPhoto(part.getSubmittedFileName()); 
			Categorydao  dao = new Categorydao(FactoryProvider.getFactory()) ;      
		    p.setCategory(dao.getCategory(cid));	
		    
		    Productdao pdao = new Productdao(FactoryProvider.getFactory()) ;
	        boolean bval =  pdao.saveproduct(p) ; 
	       
	       //uploading photo :
	       //finding path : 
		    String path = request.getRealPath("img")+File.separator + "products"+File.separator+part.getSubmittedFileName() ;
	       
		    //uploading code :
		    try {
				//write data
   FileOutputStream fos = new FileOutputStream(path) ;  
   
   //read data 
				 InputStream fis = part.getInputStream() ; 
   //reading data : 
				 
				 byte []data = new byte[fis.available()] ; 
				 
				 fis.read(data) ;
   //writing data : 
				 fos.write(data) ; 
				 fos.close();
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		     
		    System.out.println(path);
	       PrintWriter out = response.getWriter() ;  
		   HttpSession httpsession = request.getSession() ;  
		   if(bval==true) {
		   httpsession.setAttribute("message", "product saved sucessfully");
		     response.sendRedirect("Admin.jsp"); 
		     return ;
		   } 
		   if(bval==false) {
			   out.println("nahi hua") ;
		   }
		}
	}

}
