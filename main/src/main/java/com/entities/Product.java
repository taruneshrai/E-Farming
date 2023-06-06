package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int pId ; 
private String pName ;  
@Column(length=3000)
private String pDesc ;

private String PPhoto ; 

private int pPrice ;

private int pDiscount ;

private int pQuantity ; 

@ManyToOne
private Category category ;


public Product(int pId, String pName, String pDesc, String pPhoto, int pPrice, int pDiscount, int pQuantity) {
	
	this.pId = pId;
	this.pName = pName;
	this.pDesc = pDesc;
	PPhoto = pPhoto;
	this.pPrice = pPrice;
	this.pDiscount = pDiscount;
	this.pQuantity = pQuantity; 
}

public Product(String pName, String pDesc, String pPhoto, int pPrice, int pDiscount, int pQuantity,Category category) {
	
	this.pName = pName;
	this.pDesc = pDesc;
	PPhoto = pPhoto;
	this.pPrice = pPrice;
	this.pDiscount = pDiscount;
	this.pQuantity = pQuantity;
	this.category = category ;
}

public Product() {
	
}

public int getpId() {
	return pId;
}

public void setpId(int pId) {
	this.pId = pId;
}

public String getpName() {
	return pName;
}

public void setpName(String pName) {
	this.pName = pName;
}

public String getpDesc() {
	return pDesc;
}

public void setpDesc(String pDesc) {
	this.pDesc = pDesc;
}

public String getPPhoto() {
	return PPhoto;
}

public void setPPhoto(String pPhoto) {
	PPhoto = pPhoto;
}

public int getpPrice() {
	return pPrice;
}

public void setpPrice(int pPrice) {
	this.pPrice = pPrice;
}

public int getpDiscount() {
	return pDiscount;
}

public void setpDiscount(int pDiscount) {
	this.pDiscount = pDiscount;
}

public int getpQuantity() {
	return pQuantity;
}

public void setpQuantity(int pQuantity) {
	this.pQuantity = pQuantity;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

@Override
public String toString() {
	return "Product [pId=" + pId + ", pName=" + pName + ", pDesc=" + pDesc + ", PPhoto=" + PPhoto + ", pPrice=" + pPrice
			+ ", pDiscount=" + pDiscount + ", pQuantity=" + pQuantity + "]";
}

public int getpricebydiscount(){
    int aprice ; 
    aprice = (this.pPrice * this.pDiscount)/100 ;
	aprice = this.pPrice - aprice ; 
	return aprice ;
}


}
