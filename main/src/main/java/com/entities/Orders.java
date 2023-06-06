package com.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;





@Entity
public class Orders {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int Order_id ; 
	
	@ManyToOne   
	 private User user;
	 
	 @ManyToMany
	 private List<Product> product ;
 
	 
	 
	public Orders(int order_id, User user, List<Product> product) {
		super();
		Order_id = order_id;
		this.user = user;
		this.product = product;
	}
   
	public Orders( User user, List<Product> product) {
		super();
		
		this.user = user;
		this.product = product;
	}
	public int getOrder_id() {
		return Order_id;
	}

	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	} 
	 
	 
	
}
