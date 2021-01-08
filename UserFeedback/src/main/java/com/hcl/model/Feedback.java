package com.hcl.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback {

	@Id 
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedbackId;
	@Column(name="text")
	private String feedbackText;
	@Column(name="rating")
	private int feedbackRating;
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date feedbackDate;
	@Column(name="user")
	@ManyToOne(cascade=CascadeType.ALL)
	private User user;
}
