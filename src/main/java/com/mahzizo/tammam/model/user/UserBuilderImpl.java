package com.mahzizo.tammam.model.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserBuilderImpl implements UserBuilder {
	
	private User user;
	
	@NotBlank(message = "Please enter your first name")
	private String firstName;

	@NotBlank(message = "Please enter your last name")
	private String lastName;

	@NotBlank(message = "Please enter your email")
//	@Email(message = "Email should be valid")
	private String email;

	@NotBlank(message = "Please enter your password")
	private String password;
	
	public UserBuilderImpl() {
		this.user = new User();
	}

	@Override
	public UserBuilderImpl buildFirstName() {
		this.user.setFirstName(firstName);
		return this;
	}

	@Override
	public UserBuilderImpl buildLastName() {
		this.user.setLastName(lastName);		
		return this;
	}

	@Override
	public UserBuilderImpl bulidEmail() {
		this.user.setEmail(email);
		return this;
	}

	@Override
	public UserBuilderImpl buildPassword() {
		this.user.setPassword(password);		
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public User getUser() {
		return this.user;
	}
}
