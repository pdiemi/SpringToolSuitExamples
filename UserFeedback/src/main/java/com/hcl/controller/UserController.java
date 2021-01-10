package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/edit-user/{username}")
	public ModelAndView editUser(@PathVariable("username") String username) {
		User userToEdit = userService.getUserByUsername(username);
		return new ModelAndView("editUserForm","userToEdit",userToEdit);
	}

	@PostMapping("/edit-user/{username}")
	public String editUser(User user) {
		userService.updateUser(user);
		return "redirect:/all-users";
	}
	
	@GetMapping("/find-user")
	public ModelAndView findUser() {
		User userToFind = new User();
		return new ModelAndView("findUserForm","userToFind",userToFind);
	}

	@PostMapping("/find-user")
	public ModelAndView findUser(User user) {
		user = userService.getUserByUsername(user.getUserEmail());
		ModelAndView mv = new ModelAndView("user");
		if (user == null) {
			
			return new ModelAndView("userNotFound","message", "User not found! Please try again.");
		}
		else {
			mv.addObject("message", "User found");
			mv.addObject("user", user);
		}
		return mv;
	}
	
	@GetMapping("/delete-user/{username}")
	public ModelAndView deleteUser(@PathVariable("username") String username) {
		User userToDelete = userService.getUserByUsername(username);
		return new ModelAndView("deleteUserAlert","userToDelete",userToDelete);
	}

	@PostMapping("/delete-user/{username}")
	public String deleteUser(User user) {
		userService.deleteUser(user);
		return "redirect:/all-users";
	}
}
