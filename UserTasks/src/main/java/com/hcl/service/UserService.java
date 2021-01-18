package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.UserDao;
import com.hcl.model.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	public User getUserByUserEmail(String userEmail) {
		return userDao.findById(userEmail).get();
	}
}
