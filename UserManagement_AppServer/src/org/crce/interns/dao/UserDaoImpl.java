package org.crce.interns.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.crce.interns.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		//entityManager.persist(user);
		entityManager.merge(user);
	}

	@Override
	public List<User> viewUsers() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public void deleteUser(int rollNo) {
		// TODO Auto-generated method stub
		entityManager.createQuery("delete from User u where u.userRollno = :n").setParameter("n", rollNo).executeUpdate();
	}

	@Override
	public User getUser(int rollno) {
		// TODO Auto-generated method stub
		List<User> userList = entityManager.createQuery("select u from User u where u.userRollno = :n").setParameter("n", rollno).getResultList();
		return userList.get(0);
	}

	
}
