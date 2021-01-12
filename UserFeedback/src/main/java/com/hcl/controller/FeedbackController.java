package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dao.FeedbackDAO;
import com.hcl.model.Feedback;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackDAO feedbackDao;

	@GetMapping("/all-feedbacks")
	public List<Feedback> getAllFeedbacks() {
		return (List<Feedback>) feedbackDao.findAll();
	}

	/*
	 * @GetMapping("/add-feedback") public ModelAndView addFeedback() { Feedback
	 * newFeedback = new Feedback(); return new ModelAndView("feedbackForm",
	 * "newFeedback", newFeedback); }
	 */
	
	@PostMapping("/add-feedback")
	public Feedback addFeedback(@RequestBody Feedback newFeedback) {
		return feedbackDao.save(newFeedback);
	}

	@PostMapping("/add-all-feedbacks")
	public List<Feedback> addAllFeedbacka(@RequestBody List<Feedback> allFeedbacks) {
		return (List<Feedback>) feedbackDao.saveAll(allFeedbacks);
	}

	@GetMapping("/feedbacks/{id}")
	public Feedback getFeedback(@PathVariable int id) {
		return feedbackDao.findById(id).get();
	}

	@GetMapping("/feedbacks/{user}")
	public List<Feedback> getFeedbackByUser(@PathVariable String user) {
		List<Feedback> allFeedbacks = (List<Feedback>) feedbackDao.findAll();
		List<Feedback> feedbacks = new ArrayList<>();
		for (Feedback fb : allFeedbacks) {
			if (fb.getUser().equals(user)) {
				feedbacks.add(fb);
			}
		}
		return feedbacks;
	}
}
