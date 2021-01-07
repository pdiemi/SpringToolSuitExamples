package com.hcl.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.model.Employee;

public interface EmpRepository extends CrudRepository<Employee, Long>{

}
