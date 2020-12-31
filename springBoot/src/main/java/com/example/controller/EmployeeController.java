package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// Demo on spring mvc
@Controller
public class EmployeeController {

	@GetMapping("/test")  //get method maps to /test end-point
	public ModelAndView getEmployee() {
		return new ModelAndView("index");  // pass in the view name, index.jsp
	}
}
