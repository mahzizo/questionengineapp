package com.mahzizo.tammam.dao.user;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahzizo.tammam.model.user.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User getUser(String email, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hql = "from User where email=:e and password=:p";
		Query<User> query = currentSession.createQuery(hql);
		query.setParameter("e", email);
		query.setParameter("p", password);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public void saveOrUpdateUser(User user) {
		System.out.println("\nuser.getEmail() : "  + user.getEmail());
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(user);
		currentSession.flush();
		currentSession.refresh(user);
	}
		
}
