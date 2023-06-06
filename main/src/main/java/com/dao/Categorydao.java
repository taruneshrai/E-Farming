package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Category;

public class Categorydao {
   private SessionFactory factory ;

public Categorydao(SessionFactory factory) {
	super();
	this.factory = factory;
}
	
   public int saveCategory(Category cat){  
	   Session session =  this.factory.openSession() ; 
	    Transaction tx = session.beginTransaction() ; 
	     int catid = (Integer) session.save(cat) ; 
	     tx.commit();
	   session.close(); 
	   return catid ;
   } 
   
   public List<Category> getcategories(){
			List clist = new ArrayList<Category>(); 
			Session s =  this.factory.openSession() ; 
			Transaction tx = s.beginTransaction() ;    
			Query query =  s.createQuery("from Category") ;
			clist = query.list() ; 
			return clist ;
	  
   }
   
   public Category getCategory(int id) {
	   Session s =  this.factory.openSession() ; 
	   Category c = (Category) s.get(Category.class, id) ; 
	   s.close(); 
	   return c ;
   }
}
