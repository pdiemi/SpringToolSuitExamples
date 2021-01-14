package com.hcl.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RouteDelegate {

	@Autowired
	RestTemplate routeRestTemplate;

	public String callRoute(String schoolName) {
		String response = routeRestTemplate.exchange("http://localhost:9090/routes/{schoolName}", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}, schoolName).getBody();
		return "normal flow" + response;
	}
	
	@Bean
	public RestTemplate routeRestTemplate() {
		return new RestTemplate();
	}
}
