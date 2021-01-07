package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.dao.EmpRepository;
import com.hcl.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmpRepository repo;

	@PostMapping("/addemp")
	public String newEmp(Employee emp) {
		repo.save(emp);
		return "redirect:/save";
	}
	
	@GetMapping("/addemp")
	public ModelAndView addNewEmp() {
		Employee emp = new Employee();
		/*
		 * newemp: jsp end-point
		 * form: name of the form
		 * emp: 
		 * */
		return new ModelAndView("newEmp","form", emp);
	}
	
	@GetMapping("/listemp")
	public ModelAndView listEmp() {
		List<Employee> allEmps = (List<Employee>) repo.findAll();
		return new ModelAndView("emps","employees", allEmps);
	}
}
