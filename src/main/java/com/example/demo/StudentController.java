package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	CacheUtil cacheUtil;
	
	@PostMapping("/addStudent")
	public void addStudent(@RequestBody Student student) {
		cacheUtil.addStudent(student);
	}
	
	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		return cacheUtil.getStudent(id);
	}

}
