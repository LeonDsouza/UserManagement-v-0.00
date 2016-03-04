package org.crce.interns.beans;

import java.io.Serializable;
import java.util.Date;


public class UserBean implements Serializable{

	private String userName;
	private String userGender;
	private Integer userRollno;
	private String userAddress;
	private String userEmail; 
	private Date userDob;
	private String userSkills;
	private Long userPhno;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public Integer getUserRollno() {
		return userRollno;
	}
	public void setUserRollno(Integer userRollno) {
		this.userRollno = userRollno;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getUserDob() {
		return userDob;
	}
	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}
	public String getUserSkills() {
		return userSkills;
	}
	public void setUserSkills(String userSkills) {
		this.userSkills = userSkills;
	}
	public Long getUserPhno() {
		return userPhno;
	}
	public void setUserPhno(Long userPhno) {
		this.userPhno = userPhno;
	}
	
}
