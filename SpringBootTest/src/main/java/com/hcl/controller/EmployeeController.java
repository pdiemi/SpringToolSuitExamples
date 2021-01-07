package com.hcl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.hcl.dao.EmpRepository;
import com.hcl.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private EmpRepository repo;

	@PostMapping("/addEmp")
	public String newEmp(Employee emp) {
		repo.save(emp);
		return "redirect:/save";
	}
}
