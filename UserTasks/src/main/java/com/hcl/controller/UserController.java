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
	public ModelAndView register(User user) {
		ModelAndView mv = new ModelAndView("welcome");
		if (userDao.existsById(user.getUserEmail())) {
			return new ModelAndView("error", "message",
					"A user associated with email " + user.getUserEmail() + " already exists.");
		} else {
			userDao.save(user);
			mv.addObject("user", user);
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
			return new ModelAndView("error", "message",
					"User associated with email " + login.getUserEmail() + " does not exist.");
		} else {
			User user = userDao.getOne(login.getUserEmail());
			if (!user.getPassword().equals(login.getPassword())) {
				//return new ModelAndView("error", "message", "Username or password is incorrect.");
				String usr = user.getUserEmail()+" "+user.getPassword();
				String log =login.getUserEmail()+" "+login.getPassword();
				String message = usr + " / " +log;
				return new ModelAndView("error", "message", message);
			} else {
				mv.addObject("user", user);
			}
		}
		return mv;
	}
}
