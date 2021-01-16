package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Entity
public class User {

	@Id
	@Column(name="email")
	private String userEmail;
	private String password;
	@Column(name="full-name")
	private String userFullName;
}
