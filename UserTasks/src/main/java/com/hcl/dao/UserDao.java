package com.hcl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.User;

public interface UserDao extends JpaRepository<User, String>{

}
