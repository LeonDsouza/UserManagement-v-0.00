package org.crce.interns.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable{
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_gender")
	private String userGender;
	
	@Id
	@Column(name = "user_rollno")
	private Integer userRollno;
	
	@Column(name = "user_address")
	private String userAddress;
	
	@Column(name = "user_email")
	private String userEmail; 
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_dob")
	private Date userDob;
	
	@Column(name = "user_skills")
	private String userSkills;
	
	@Column(name = "user_phno")
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
