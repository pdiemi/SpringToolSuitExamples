package com.hcl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.Task;

public interface TaskDao extends JpaRepository<Task, Integer> {

}
