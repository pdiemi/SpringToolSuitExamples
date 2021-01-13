package com.hcl.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class StudentDelegate {

	@Autowired
	RestTemplate restTemplate;

	/*
	 * By default, the waiting time for response from the target URL is 500ms.
	 * In StudentService controller, we set thread.sleep(1000) which
	 * delays the response from target URL by 1000ms, thus we'll see
	 * the circuit breaker by default.
	 * However, we can change the waiting time by set @HystricProperties and 
	 * set the waiting time (timeoutInMilliseconds) to 2000ms for example.
	 * */
	@HystrixCommand(fallbackMethod = "callAtFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000") })
	public String callStudent(String schoolName) {
		String response = restTemplate.exchange("http://localhost:8080/students/{schoolName}", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}, schoolName).getBody();
		return "normal flow" + response;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public String callAtFallback(String data) {
		return "circuit breaker enable... please try again some time";
	}
}
