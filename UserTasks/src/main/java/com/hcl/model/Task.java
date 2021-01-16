package com.hcl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskId;
	@Column(name="name")
	private String taskName;
	@Column(name="start-date")
	private Date taskStartDate;
	@Column(name="end-date")
	private Date taskEndDate;
	@Column(name="description")
	private String taskDescription;
	@Column(name="severity")
	private String taskSeverity;
	@Column(name="user")
	private String taskEmail;
}
