package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.dao.TaskDao;
import com.hcl.model.Task;

@Controller
public class TaskController {

	@Autowired
	private TaskDao taskDao;

	@GetMapping("/{user}/all-tasks")
	public ModelAndView getAllTasks(@PathVariable String user) {
		List<Task> allTasks = taskDao.findAll();
		List<Task> taskList = new ArrayList<>();
		for (Task task : allTasks) {
			if (task.getTaskEmail().equals(user)) {
				taskList.add(task);
			}
		}
		return new ModelAndView("dashboard", "taskList", taskList);
	}

	@GetMapping("/{user}/add-task")
	public ModelAndView addTask(@PathVariable String user) {
		Task newTask = new Task();
		newTask.setTaskEmail(user);
		return new ModelAndView("taskForm", "newTask", newTask);
	}
	
	@PostMapping("/{user}/add-task")
	public String addTask(Task newTask) {
		taskDao.save(newTask);
		return "redirect:/"+newTask.getTaskEmail()+"/all-tasks";
	}
}
