package com.hcl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.hcl.dao.FeedbackDAO;
import com.hcl.model.Feedback;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackDAO feedbackDao;

	@GetMapping("/all-feedbacks")
	public ResponseEntity<List<Feedback>> getAllFeedbacks() {
		List<Feedback> allFeedbacks = (List<Feedback>) feedbackDao.findAll();
		if (allFeedbacks.isEmpty()) {
			return new ResponseEntity<List<Feedback>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Feedback>>(allFeedbacks, HttpStatus.OK);
	}

	@GetMapping("/add-feedback")
	public ModelAndView addFeedback() {
		Feedback newFeedback = new Feedback();
		return new ModelAndView("feedbackForm", "newFeedback", newFeedback);
	}

	@PostMapping("/add-feedback")
	public ResponseEntity<String> addFeedback(Feedback newFeedback, UriComponentsBuilder ucBuilder,
			HttpServletResponse response) throws IOException {
		Date currentDate = Calendar.getInstance().getTime();
		newFeedback.setFeedbackDate(currentDate);
		feedbackDao.save(newFeedback);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/feedback/{id}").buildAndExpand(newFeedback.getFeedbackId()).toUri());
		response.sendRedirect("/all-feedbacks");
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@PostMapping("/add-all-feedbacks")
	public List<Feedback> addAllFeedbacka(@RequestBody List<Feedback> allFeedbacks) {
		return (List<Feedback>) feedbackDao.saveAll(allFeedbacks);
	}

	@GetMapping("/feedbacks/{id}")
	public ResponseEntity getFeedbackById(@PathVariable int id) {
		Feedback feedback = feedbackDao.findById(id).get();
		if (feedback == null) {
			return new ResponseEntity<Feedback>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Feedback>(feedback, HttpStatus.OK);
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
