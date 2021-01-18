package com.hcl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Column(name="startdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date taskStartDate;
	@Column(name="enddate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date taskEndDate;
	@Column(name="description")
	private String taskDescription;
	@Column(name="severity")
	private String taskSeverity;
	@Column(name="user")
	private String taskEmail;
	@Transient
	private User user;
}
