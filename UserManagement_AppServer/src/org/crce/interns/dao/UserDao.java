package org.crce.interns.dao;

import java.util.List;
import org.crce.interns.model.User;

public interface UserDao {

	public void createUser(User user);
	public List<User> viewUsers();
	public void deleteUser(int rollNo);
	public User getUser(int rollno);
}
