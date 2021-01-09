package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.User;
import com.hcl.service.UserServiceInterface;

@Controller
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	@GetMapping("/dashboard")
	public String showDashBoard() {
		return "dashboard";
	}
	
	@GetMapping("/all-users")
	public ModelAndView getAllUsers() {
		List<User> userList = userService.getAllUsers();
		return new ModelAndView("users","userList",userList);
	}

	@GetMapping("/add-user")
	public ModelAndView addUser() {
		User newUser = new User();
		return new ModelAndView("userForm","newUser",newUser);
	}

	@PostMapping("/add-user")
	public String addUser(User user) {
		String errorMessage = "";
		if(userService.userExists(user)) {
			
		}
		userService.addUser(user);
		return "redirect:/all-users";
	}

	@GetMapping("/edit-user")
	public ModelAndView editUser() {
		User userToEdit = new User();
		return new ModelAndView("userEditForm","userToEdit",userToEdit);
	}

	@PostMapping("/edit-user")
	public String editUser(User user) {
		userService.updateUser(user);
		return "redirect:/all-users";
	}
	
}
