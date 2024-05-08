package com.example.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepo;
	
//	@Test
//	public void saveCourseMaterial() {
//		
//		Course course = Course.builder()
//				.title("CSE 101")
//				.credit("4")
//				.build();
//		
//		CourseMaterial courseMaterial = CourseMaterial.builder()
//				.url("www.google.com")
//				.course(course)
//				.build();
//		
//		
//		courseMaterialRepo.save(courseMaterial);
//		
//	}
	
	@Test
	public void printAllCourses() {
		List<CourseMaterial> courseMaterials = courseMaterialRepo.findAll();
		
		System.out.println(courseMaterials+ " <--> "+courseMaterials.get(0).getCourse().getTitle());
	}


}
