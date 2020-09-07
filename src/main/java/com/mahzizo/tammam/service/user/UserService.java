package com.mahzizo.tammam.service.user;

import com.mahzizo.tammam.model.user.User;

public interface UserService {
	
	User getUser(String email, String password);
	
	public void saveOrUpdateUser(User user);

}
