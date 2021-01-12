package com.hcl.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentDelegate {

	@Autowired
	RestTemplate restTemplate;

	public String callStudent(String schoolName) {
		String response = restTemplate.exchange("http://localhost:8080/students/{schoolName}", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}, schoolName).getBody();
		return "normal flow" + response;
	}
	
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
