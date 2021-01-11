package com.hcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.FeedbackDAO;
import com.hcl.model.Feedback;

@Service
@Transactional
public class FeedbackService implements FeedbackServiceInterface{

	@Autowired
	private FeedbackDAO feedbackDao;
	
	@Override
	public List<Feedback> getAllFeedbacks() {
		return (List<Feedback>) feedbackDao.findAll();
	}

	@Override
	public List<Feedback> getAllFeedbacksByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Feedback getFeedbackByID(int id) {
		Optional<Feedback> feedback = feedbackDao.findById(id);
		if (feedback.isPresent()) {
			return feedback.get();
		}
		return null;
	}

	@Override
	public void addFeedback(Feedback feedback) {
		feedbackDao.save(feedback);
	}

	@Override
	public void addAllFeedbacks(List<Feedback> allFeedbacks) {
		feedbackDao.saveAll(allFeedbacks);
	}

	

}
