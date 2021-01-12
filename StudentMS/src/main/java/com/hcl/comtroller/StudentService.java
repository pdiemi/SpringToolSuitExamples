package com.hcl.comtroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.domain.Student;

@RestController
public class StudentService {

	private static Map<String, List<Student>> schooldb = new HashMap<>();
	
	static {
		//schooldb = new HashMap<>();
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("amar", "class 1"));
		list.add(new Student("diemi", "class 2"));
		
		schooldb.put("abcschool", list);
	}
	
	@RequestMapping("/students/{schoolName}")
	public List<Student> getStudents(@PathVariable String schoolName) {
		List<Student> studentList = schooldb.get(schoolName);
		
		if (studentList == null) {
			studentList = new ArrayList<>();
			Student student = new Student("Not found", "NA");
			studentList.add(student);
			
		}
		return studentList;
	}
}
