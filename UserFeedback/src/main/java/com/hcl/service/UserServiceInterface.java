package com.hcl.service;

import java.util.List;

import com.hcl.model.User;

public interface UserServiceInterface {

	public List<User> getAllUsers();
	public User getUserByUsername(String username);
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public boolean userExists(User user);
}
