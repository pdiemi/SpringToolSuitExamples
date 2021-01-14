package com.hcl.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.domain.RouteDelegate;
import com.hcl.domain.StudentDelegate;

@RestController
public class MainApp {

	@Autowired
	StudentDelegate studentDelegate;
	@Autowired
	RouteDelegate routeDelegate;
	
	@GetMapping("/loadstudents/{schoolName}")
	public String getStudents(@PathVariable String schoolName) {
		return studentDelegate.callStudent(schoolName);
	}
	
	@GetMapping("/loadroutes/{schoolName}")
	public String getRoutes(@PathVariable String schoolName) {
		return routeDelegate.callRoute(schoolName);
	}
}
