package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheUtil {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Cacheable(value="cache1", key="#id")
	public Student getStudent(int id) {
		System.out.println("from dadtabase");
		return studentRepository.findOne(id);
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

}
