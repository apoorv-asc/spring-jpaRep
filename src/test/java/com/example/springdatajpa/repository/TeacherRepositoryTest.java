package com.example.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdatajpa.entity.Course;
import com.example.springdatajpa.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository teacherRepo;

	@Test
	public void saveTeacher() {
		Course courseDBA = Course.builder()
				.title("DBA")
				.credit("5")
				.build();
		
		Course courseJava = Course.builder()
				.title("Java")
				.credit("5")
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Aditi")
				.lastName("Bajaj")
				.courses(List.of(courseDBA,courseJava))
				.build();
		
		teacherRepo.save(teacher);
	}
	
}
