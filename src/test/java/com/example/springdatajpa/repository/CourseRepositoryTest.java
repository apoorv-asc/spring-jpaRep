package com.example.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdatajpa.entity.Course;

@SpringBootTest
public class CourseRepositoryTest{
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Test
	public void saveCourse() {
		
	}
	
	@Test
	public void printCourses() {
		List<Course> courses = courseRepo.findAll();
		
		System.out.println("Courses : " + courses);
	}
	
	@Test
	public void saveTeacherWithCourses() {
		
	}

}