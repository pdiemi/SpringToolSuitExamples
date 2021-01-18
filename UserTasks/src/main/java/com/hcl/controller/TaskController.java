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
import com.hcl.service.UserService;

@Controller
public class TaskController {

	@Autowired
	private TaskDao taskDao;
	@Autowired
	UserService userService;

	@GetMapping("/{user}/all-tasks")
	public ModelAndView getAllTasks(@PathVariable String user) {
		List<Task> allTasks = taskDao.findAll();
		List<Task> taskList = new ArrayList<>();
		ModelAndView mv = new ModelAndView("dashboard");
		mv.addObject("user", userService.getUserByUserEmail(user));
		for (Task task : allTasks) {
			if (task.getTaskEmail().equals(user)) {
				taskList.add(task);
			}
		}
		mv.addObject("taskList", taskList);
		return mv;
	}

	@GetMapping("/{user}/add-task")
	public ModelAndView addTask(@PathVariable String user) {
		Task newTask = new Task();
		newTask.setTaskEmail(user);
		return new ModelAndView("taskForm", "newTask", newTask);
	}
	
	@PostMapping("/{user}/add-task")
	public String addTask(Task newTask, @PathVariable String user) {
		taskDao.save(newTask);
		return "redirect:/"+user+"/all-tasks";
	}
	
	@GetMapping("/{user}/update-task/{taskid}")
	public ModelAndView updateTask(@PathVariable("taskid") int taskId) {
		Task task = taskDao.findById(taskId).get();
		return new ModelAndView("updateTaskForm", "newTask", task);
	}
	
	@PostMapping("/{user}/update-task/{taskid}")
	public String updateTask(Task task, @PathVariable("user") String user) {
		taskDao.save(task);
		return "redirect:/"+user+"/all-tasks";
	}
	
	@GetMapping("/{user}/delete-task/{taskid}")
	public ModelAndView deleteTask(@PathVariable("taskid") int taskId) {
		Task task = taskDao.findById(taskId).get();
		return new ModelAndView("deleteTaskForm", "newTask", task);
	}
	
	@PostMapping("/{user}/delete-task/{taskid}")
	public String deleteTask(Task task, @PathVariable("user") String user) {
		taskDao.delete(task);;
		return "redirect:/"+user+"/all-tasks";
	}
}
