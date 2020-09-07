package com.mahzizo.tammam.dao.user;

import com.mahzizo.tammam.model.user.User;

public interface UserDAO {
	
	User getUser(String email, String password);
	
	public void saveOrUpdateUser(User user);
	
}
