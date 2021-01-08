package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.UserDAO;
import com.hcl.model.User;

@Service
@Transactional
public class UserService implements UserServiceInterface {

	@Autowired
	private UserDAO userDao;
	
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userDao.findAll();
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.findById(username).get();
	}

	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.delete(user);
		userDao.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

}
