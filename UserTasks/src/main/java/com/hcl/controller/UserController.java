package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.dao.UserDao;
import com.hcl.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping("/register")
	public ModelAndView register() {
		User newUser = new User();
		return new ModelAndView("registerForm", "newUser", newUser);
	}

	@PostMapping("/register")
	public ModelAndView register(User newUser) {
		ModelAndView mv = new ModelAndView("welcome");
		if (userDao.existsById(newUser.getUserEmail())) {
			return new ModelAndView("registerFail", "message",
					"A user associated with email " + newUser.getUserEmail() + " already exists.");
		} else {
			userDao.save(newUser);
			mv.addObject("newUser", newUser);
		}
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		User user = new User();
		return new ModelAndView("loginForm", "user", user);
	}

	@PostMapping("/login")
	public ModelAndView login(User login) {
		ModelAndView mv = new ModelAndView("welcome");
		if (!userDao.existsById(login.getUserEmail())) {
			return new ModelAndView("registerFail", "message",
					"User associated with email " + login.getUserEmail() + " does not exist.");
		} else {
			User user = userDao.getOne(login.getUserEmail());
			if (user.getPassword() != login.getPassword()) {
				return new ModelAndView("registerFail", "message", "Username or password is incorrect.");
			} else {
				mv.addObject("user", user);
			}
		}
		return mv;
	}
}
