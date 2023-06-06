package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Userdao;
import com.entities.User;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		 try {
			String email  = request.getParameter("email") ;
			 String password = request.getParameter("password") ; 
			 //validation 
			 
			 //authenrication user ;
			  Userdao ud = new Userdao(FactoryProvider.getFactory()) ;  
			  User user = ud.getUser(email, password) ; 
			  //System.out.println(user);  
			  PrintWriter out = response.getWriter() ; 
			  
			  HttpSession httpsession = request.getSession();  
			  
			  if(user==null) {
				  
				   httpsession.setAttribute("message","Invalid Details" ); 
				   response.sendRedirect("Login.jsp"); 
				   return ;
			  } 
			  else {
				   httpsession.setAttribute("current-user", user); 
				   
				   if(user.getUserType().equals("admin")) {
					    response.sendRedirect("Admin.jsp");
				   } 
				   else if(user.getUserType().equals("normalUser")) {
					   response.sendRedirect("index.jsp");
				   } 
				   else {
					   out.println(" not identified usertype");
				   }
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
