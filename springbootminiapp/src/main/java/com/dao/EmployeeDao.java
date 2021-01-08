package com.dao;

import org.springframework.stereotype.Repository;

import com.model.Employee;
import com.model.Employees;

@Repository
public class EmployeeDao {

	private static Employees emp = new Employees();
	
	static {
		emp.getEmpList().add(new Employee(101, "emp1", "lname", "email"));
		emp.getEmpList().add(new Employee(102, "emp2", "lname", "email"));
		emp.getEmpList().add(new Employee(103, "emp3", "lname", "email"));
		emp.getEmpList().add(new Employee(104, "emp4", "lname", "email"));
	}
	
	public Employees getAllEmp() {
		return emp;
	}
	
	public void addEmployee(Employee newEmp) {
		emp.getEmpList().add(newEmp);
	}
}
