package com.hcl.service;

import java.util.List;

import com.hcl.model.Feedback;

public interface FeedbackServiceInterface {

	
	public List<Feedback> getAllFeedbacks();
	public List<Feedback> getAllFeedbacksByUser(String user);
	public Feedback getFeedbackByID(int id);
	public void addFeedback(Feedback feedback);
	public void addAllFeedbacks(List<Feedback> allFeedbacks);

}
