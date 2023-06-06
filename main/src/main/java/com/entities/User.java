package com.entities;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class User {

@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int userid ;  

private String userName ; 

@Column(unique = true)
private String userEmail ;
 
private String userPassword ; 

private long userPhone ; 

private String userPic ; 

@Column(length=1500)
private String userAddress ;

private String userType ;
 
@OneToMany(mappedBy ="user")
private List<Orders> orders ; 

public User(int userid, String userName, String userEmail, String userPassword, long userPhone, String userPic,
		String userAddress,String userType) {
	
	this.userid = userid;
	this.userName = userName;
	this.userEmail = userEmail;
	this.userPassword = userPassword;
	this.userPhone = userPhone;
	this.userPic = userPic;
	this.userAddress = userAddress; 
	this.userType = userType ;
} 


public User(String userName, String userEmail, String userPassword, long userPhone, String userPic, String userAddress, String userType) {
	
	this.userName = userName;
	this.userEmail = userEmail;
	this.userPassword = userPassword;
	this.userPhone = userPhone;
	this.userPic = userPic;
	this.userAddress = userAddress; 
	this.userType = userType ;
}


public User() {
	
}


public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserEmail() {
	return userEmail;
}
public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public long getUserPhone() {
	return userPhone;
}
public void setUserPhone(long userPhone) {
	this.userPhone = userPhone;
}
public String getUserPic() {
	return userPic;
}

public void setUserPic(String userPic) {
	this.userPic = userPic;
}
public String getUserAddress() {
	return userAddress;
}
public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}


@Override
public String toString() {
	return "User [userid=" + userid + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
			+ userPassword + ", userPhone=" + userPhone + ", userPic=" + userPic + ", userAddress=" + userAddress + "]";
}


public String getUserType() {
	return userType;
}


public void setUserType(String userType) {
	this.userType = userType;
}


}
