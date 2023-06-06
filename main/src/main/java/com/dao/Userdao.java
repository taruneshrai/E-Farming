package com.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;

import com.entities.User;
import com.mysql.cj.xdevapi.Session;

public class Userdao {
  
	private SessionFactory factory ; 
	
	public Userdao(SessionFactory factory) {
		this.factory = factory ; 
	} 
	
	public User getUser(String email,String password) {
		 User user = null ; 
		 
		 try {
			 String query ="from User where userEmail = :e and userPassword = :p" ; 
			 org.hibernate.Session session  = this.factory.openSession() ; 
			 Query q =   session.createQuery(query) ; 
			 q.setParameter("e", email) ; 
			 q.setParameter("p",password) ; 
			 
			   user = (User) q.uniqueResult() ;
			 session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 return user ;
	} 
	
	public Long getUsercount(){
	 
	 String q1 = "Select count(*) from User" ;
	 org.hibernate.Session session  = this.factory.openSession() ;
		Query q = session.createQuery(q1) ; 
		
	 long count = (Long) q.list().get(0) ; 
	 session.close();
	 return count ;
	}
}
