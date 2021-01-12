package com.hcl.comtroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.domain.Route;

@RestController
public class TransportService {

	private static Map<String, List<Route>> schooldb = new HashMap<>();
	
	static {
		List<Route> routes = new ArrayList<>();
		
		routes.add(new Route("city bus", 1));
		routes.add(new Route("shuttle", 0));
		
		schooldb.put("abcschool", routes);
	}
	
	@RequestMapping("/routes/{schoolName}")
	public List<Route> getRoutes(@PathVariable String schoolName){
		List<Route> routes = schooldb.get(schoolName);
		
		if (routes == null){
			routes = new ArrayList<>();
			routes.add(new Route("Not found", 0));
		}
		return routes;
	}
}
