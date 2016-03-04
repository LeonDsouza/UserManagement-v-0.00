package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.UserBean;
import org.springframework.stereotype.Service;

public interface UserService {
	
	public void createUser(UserBean userBean);
	public List<UserBean> viewUsers();
	public void deleteUser(int rollNo);
	public UserBean getUser(int rollno);
}
