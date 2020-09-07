package com.mahzizo.tammam.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mahzizo.tammam.dao.user.UserDAO;
import com.mahzizo.tammam.model.user.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public User getUser(String email, String password) {
		return userDAO.getUser(email, password);
	}
	
	@Override
	@Transactional
	public void saveOrUpdateUser(User user) {
		userDAO.saveOrUpdateUser(user);
	}
	
	
}
