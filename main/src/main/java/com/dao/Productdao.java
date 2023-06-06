package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.entities.Product;



public class Productdao {
  
	 private SessionFactory factory ;

	 public Productdao(SessionFactory factory) {
	 	super();
	 	this.factory = factory;
	 } 
	 
	 public boolean saveproduct(Product p) { 
		 boolean d;
		try {
			Session session  = this.factory.openSession();
			Transaction tx = session.beginTransaction() ;
			session.save(p) ;
			tx.commit(); 
			session.close();
			 d =true ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			d =false; 
		}
		return d; 
	 } 
	 
	 public List<Product> getallproducts(){
		 Session s  = this.factory.openSession();
		  Query query = s.createQuery("from Product");
		  List<Product> list = query.list() ; 
		  return list ;
	 } 
	 
	 public List<Product> getproductbyCategoryID(int id){
		 List<Product> list = null;
		try {
			Session s  = this.factory.openSession();
			  Query query = s.createQuery("from Product as p where p.category.categoryId = :e");
			  query.setParameter("e", id) ;
			  list = query.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  return list;
	 } 
	 
	 public Long getProductcount(){
		 
		 String q1 = "Select count(*) from Product" ;
		 org.hibernate.Session session  = this.factory.openSession() ;
			Query q = session.createQuery(q1) ; 
			
		 long count = (Long) q.list().get(0) ;  
		 session.close();
		 return count ;
		}
	 
	 public List<Product> getitembylist(List<String> ls){
		   List<Product> fd = new ArrayList<Product>(); 
		   Session session = factory.openSession();
		   for(int i =0 ;i<ls.size();i++) {
		   Query query = session.createQuery("from Product as p where p.pName  = :e"); 
		   query.setParameter("e", ls.get(i)) ;
			  fd.add((Product) query.list().get(0));
		   }
		   return fd ;
	 } 
	 
	 public List<Product> getsearch(String s){
		 List<Product> fd = new ArrayList<Product>();  
		 try {
			
			   Session session = factory.openSession();
			  
			   Query query = session.createQuery("FROM Product as p WHERE p.pName LIKE :e or p.category Like :e "); 
			  
			   query.setParameter("e", "%"+s+"%");
				  fd  =  query.list();	   

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 return fd ; 
	 }
	
	
	 
}
