package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.*;

@Entity
public class Category {

@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int categoryId ;

private String categoryTitle ;

@Column(length=300)
private String categoryDesc ;

@OneToMany(mappedBy="category")
private List<Product> products = new ArrayList<Product>() ;

public Category(int categoryId, String categoryTitle, String categoryDesc) {
	
	this.categoryId = categoryId;
	this.categoryTitle = categoryTitle;
	this.categoryDesc = categoryDesc;
}
public Category( String categoryTitle, String categoryDesc) {
	
	
	this.categoryTitle = categoryTitle;
	this.categoryDesc = categoryDesc;
}

public Category(String categoryTitle, String categoryDesc,List<Product> products) {
	
	this.categoryTitle = categoryTitle;
	this.categoryDesc = categoryDesc; 
	this.products = products ;
}



public List<Product> getProducts() {
	return products;
}


public void setProducts(List<Product> products) {
	this.products = products;
}


public Category() {
	
}


public int getCategoryId() {
	return categoryId;
}

public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}

public String getCategoryTitle() {
	return categoryTitle;
}

public void setCategoryTitle(String categoryTitle) {
	this.categoryTitle = categoryTitle;
}

public String getCategoryDesc() {
	return categoryDesc;
}

public void setCategoryDesc(String categoryDesc) {
	this.categoryDesc = categoryDesc;
}


@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDesc=" + categoryDesc
			+ "]";
} 

	
}
