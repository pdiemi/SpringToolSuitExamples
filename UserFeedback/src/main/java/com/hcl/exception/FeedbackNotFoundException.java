package com.hcl.exception;

public class FeedbackNotFoundException extends RuntimeException{

	public FeedbackNotFoundException(int id) {
		super("Could not find feedback " + id);
	}
}
