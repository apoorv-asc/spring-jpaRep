package com.example.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdatajpa.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
//	@Test
//	public void saveStudent() {
//		Student student = Student.builder()
//							.emailId("apoorv@gmail.com")
//							.firstName("Apoorv")
//							.lastName("Singh")
//							.guardianName("Vaibhav Singh")
//							.guardianMobile("8115566990")
//							.guardianEmail("vaibhav@gmail.com")
//							.build();
//		
//		studentRepository.save(student);
//	}
	
	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println("Student : "+studentList);
	}

}
