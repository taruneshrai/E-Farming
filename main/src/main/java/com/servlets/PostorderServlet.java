package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Orderdao;
import com.dao.Productdao;
import com.entities.Product;
import com.entities.User;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class PostorderServlet
 */
public class PostorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostorderServlet() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
		   String[] myJsonData = request.getParameterValues("json[]"); 
           List<String> li = new ArrayList<String>();
          for(String s:myJsonData) {
          	 li.add(s) ; 
          	 System.out.println(s);
          }   
          
          Productdao pd = new Productdao(FactoryProvider.getFactory()) ;  
           
          List<Product> plist  = pd.getitembylist(li) ;  
          
          HttpSession hts = request.getSession() ; 
            User user  =  (User) hts.getAttribute("current-user") ; 
             
           Orderdao od = new Orderdao(FactoryProvider.getFactory()) ; 
              
            boolean bp = od.saveorder(user, plist) ; 
            
            if(bp) {
           	 System.out.println("complete");
           	 HttpSession hr = request.getSession() ;
            hr.setAttribute("message", "Sucessfully ordered");
            response.sendRedirect("Checkout.jsp");
            }
            else {
           	 
           	 HttpSession hr = request.getSession() ;
	             hr.setAttribute("message", "not ordered");
                response.sendRedirect("checkout.jsp"); 
            }
	}

}
