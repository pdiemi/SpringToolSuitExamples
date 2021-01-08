package com.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dao.EmployeeDao;
import com.model.Employee;
import com.model.Employees;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping(path="/", produces="application/json")
	public Employees getEmployees(
			@RequestHeader(name="X-COM-PERSIST", required=true) String headerPersist,
			@RequestHeader(name="X-COM-LOCATION", required=true) String headerLocation) {
		return employeeDao.getAllEmp();
	}
	
	@PostMapping("/")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee emp){
		/*
		 * Set new emp's id by adding 1 to the empList size.
		 * This logic is not correct but fine for this demo purpose.
		 */
		Integer id = employeeDao.getAllEmp().getEmpList().size()+1;
		emp.setId(id);
		employeeDao.addEmployee(emp);
		
		// Create new record resource location
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(emp.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
