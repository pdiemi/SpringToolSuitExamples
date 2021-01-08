package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.model.User;
import com.hcl.service.UserServiceInterface;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	@GetMapping("/all-users")
	public String getAllUsers(ModelMap model) {
		List<User> userList = userService.getAllUsers();
		model.addAttribute("userList", userList);
		return "users";
	}

	@GetMapping("/add-user")
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "userForm";
	}

	@PostMapping("/add-user")
	public String addUser(ModelMap model, User user, BindingResult result) {
		if (result.hasErrors()) {
			return "userForm";
		}
		userService.addUser(user);
		return "redirect:/users";
	}

}
