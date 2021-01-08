package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id 
	@Column(name="email")
	private String userEmail;
	@Column(name="password")
	private String userPassword;
	@Column(name="name")
	private String userFullName;
	@Column(name="country")
	private String Country;
}
