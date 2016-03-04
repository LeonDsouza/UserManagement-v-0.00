package org.crce.interns.service;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.UserBean;
import org.crce.interns.dao.UserDao;
import org.crce.interns.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void createUser(UserBean userBean) {
		// TODO Auto-generated method stub
		User user = new User();
		BeanUtils.copyProperties(userBean, user);
		//user.setUserDob(new java.sql.Date(userBean.getUserDob().getTime()));
		userDao.createUser(user);
	}

	@Override
	public List<UserBean> viewUsers() {
		// TODO Auto-generated method stub
		List<User> userList = userDao.viewUsers();
		return convertToBean(userList);
	}

	public List<UserBean> convertToBean(List<User> userList) {
		List<UserBean> userBeanList = new ArrayList<UserBean>();
		for (User user : userList) {
			UserBean userBean = new UserBean();
			BeanUtils.copyProperties(user, userBean);
			userBeanList.add(userBean);
		}
		return userBeanList;
	}

	@Override
	public void deleteUser(int rollNo) {
		// TODO Auto-generated method stub
		userDao.deleteUser(rollNo);
	}

	@Override
	public UserBean getUser(int rollno) {
		// TODO Auto-generated method stub
		UserBean userBean = new UserBean();
		User user = userDao.getUser(rollno);
		BeanUtils.copyProperties(user, userBean);
		return userBean;
	}
}
