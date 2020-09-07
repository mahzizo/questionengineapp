package com.mahzizo.tammam.model.user;

public interface UserBuilder {
	
	public UserBuilder buildFirstName();
	  
    public UserBuilder buildLastName();
  
    public UserBuilder bulidEmail();
  
    public UserBuilder buildPassword();
  
    public User getUser();
	
}
