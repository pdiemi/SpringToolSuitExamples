package com.demoapp.springbootDemo;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.model.Employee;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SpringbootDemoApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */

	@LocalServerPort
	int randomPort;

	@Test
	public void testGetEmployee() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:" + randomPort + "/employees/";

		URI uri = new URI(baseUrl);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-LOCATION", "USA");

		HttpEntity<Employee> requEntity = new HttpEntity<>(null, headers);

		try {
			restTemplate.exchange(uri, HttpMethod.GET, requEntity, String.class);
			Assert.fail();
		} catch (HttpClientErrorException ex) {
			Assert.assertEquals(400, ex.getRawStatusCode());
			Assert.assertEquals(true, ex.getResponseBodyAsString().concat("Missing request header"));
		}

		// ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

	}
}
