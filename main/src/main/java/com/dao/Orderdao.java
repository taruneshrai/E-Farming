package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Orders;
import com.entities.Product;
import com.entities.User;



public class Orderdao {
 
	 
		SessionFactory factory ; 
		public Orderdao(SessionFactory factory){
			this.factory = factory ;
		} 
		
		public boolean saveorder( User user, List<Product> products){
		    
			boolean bo = false ; 
			
			try {
				long millis=System.currentTimeMillis();  
				java.sql.Date date=new java.sql.Date(millis);   
				Orders od = new Orders(  user,  products);
				Session session = this.factory.openSession();
				Transaction tx = session.beginTransaction() ;  
				 session.save(od) ; 
				 tx.commit(); 
				 session.close(); 
				 bo =true ;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 bo =false ;
			}
		    return bo ;
		}
		
}
