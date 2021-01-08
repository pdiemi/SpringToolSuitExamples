package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/deleteemp/{id}")
    public ModelAndView deleteEmployeeForm(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("deleteForm");
        Employee emp =  repo.findById(id).get();
        mav.addObject("deleteEmp", emp);
    
        return mav;
    }
	
	@PostMapping("/deleteemp/{id}")
	public String deleteEmp(@ModelAttribute("emp") Employee emp) {
		repo.delete(emp);
		return "redirect:/listemp";
	}

	@GetMapping("/editemp/{id}")
    public ModelAndView editEmployeeForm(@PathVariable("id") long id) {
        ModelAndView mav = new ModelAndView("editForm");
        Employee emp =  repo.findById(id).get();
        mav.addObject("editEmp", emp);
    
        return mav;
    }

    @PostMapping("/editemp/{id}")
    public String editsaveEmp(@ModelAttribute("emp") Employee emp) {
        
        repo.save(emp);
        return ("redirect:/listemp");
       }
}
