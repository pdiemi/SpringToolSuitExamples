package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return "redirect:/listemp";
	}
	
	@GetMapping("/addemp")
	public ModelAndView addNewEmp() {
		Employee emp = new Employee();
		/*
		 * newemp: jsp end-point
		 * form: name of the form in jsp
		 * emp: oject
		 * */
		return new ModelAndView("newEmp","form", emp);
	}
	
	@GetMapping("/listemp")
	public ModelAndView listEmp() {
		List<Employee> allEmps = (List<Employee>) repo.findAll();
		return new ModelAndView("emps","employees", allEmps);
	}
	
	@PutMapping("/updateemp/{id}")
	public ModelAndView updateEmp(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("editForm");
		Employee emp = repo.findById(id).get();
		mv.addObject("emp",emp);
		return mv;
	}
	
	@PutMapping("/deleteemp/{id}")
	public String deleteEmp(@PathVariable("id") long id) {
		repo.deleteById(id);
		return "redirect:/listemp";
	}
	
	public String showForm(Model model) {
		model.addAttribute("command", new Employee());
		return "newEmp";
	}
	
	@GetMapping("/editemp/{id}")
	public String editGetEmp(@PathVariable("id") long id, Model model) {
		Employee emp = repo.findById(id).get();
		model.addAttribute("command", emp);
		return "editForm";
	}
	
	@PutMapping("/save")
	public String editSaveEmp(@ModelAttribute("emp") Employee emp) {
		repo.save(emp);
		return "redirect:/listemp";
	}
}
