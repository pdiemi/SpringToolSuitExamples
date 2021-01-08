package com.hcl.dao;

import org.springframework.data.repository.CrudRepository;

import com.hcl.model.User;

public interface UserDAO extends CrudRepository<User, String> {

}
