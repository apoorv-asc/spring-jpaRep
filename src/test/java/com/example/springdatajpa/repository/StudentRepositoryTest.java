package com.example.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdatajpa.entity.Guardian;
import com.example.springdatajpa.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
							.emailId("apoorv@gmail.com")
							.firstName("Apoorv")
							.lastName("Singh")
//							.guardianName("Vaibhav Singh")
//							.guardianMobile("8115566990")
//							.guardianEmail("vaibhav@gmail.com")
							.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {
		Guardian guardian = Guardian.builder()
				.name("Prakhar")
				.mobile("6387590095")
				.email("prakhar@gmail.com").build();
		
		Student student = Student.builder()
				.emailId("nitesh@gmail.com")
				.firstName("Nitesh")
				.lastName("Pandey")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		System.out.println("Student : "+studentList);
	}
	
	@Test
	public void printStudentWithFirstName() {
		List<Student> studentList = studentRepository.findByFirstName("Apoorv");
		System.out.println("Student List :\n"+studentList);
	}
	
	@Test
	public void printStudentWithFirstNameContaining() {
		List<Student> studentList = studentRepository.findByFirstNameContaining("orv");
		System.out.println("Student List :\n"+studentList);
	}
	
	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> studentList = studentRepository.findByGuardianName("Prakhar");
		System.out.println("Student List :\n"+studentList);
	}
	
	@Test
	public void findByFirstNameAndLastNameTest() {
		Student studentList = studentRepository.findByFirstNameAndLastName("Nitesh","Pandey");
		System.out.println("Student List :\n"+studentList);
	}
	
	@Test
	public void getStudentWithEmail() {
		Student std = studentRepository.getStudentByEmailAddress("apoorv@gmail.com");
		
		System.out.println("Student ---> "+std);
	}

	@Test
	public void getStudentFirstNameWithEmail() {
		String std = studentRepository.getStudentFirstNameByEmailAddress("nitesh@gmail.com");
		
		System.out.println("First Name of Student ---> "+std);
	}
	
	@Test
	public void getStudentWithEmailNativeNamedParam() {
		Student std = studentRepository.getStudentByEmailAddressNative("nitesh@gmail.com");
		
		System.out.println("First Name of Student ---> "+std);
	}
	
	@Test
	public void updateFirstNameFromEmail() {
		studentRepository.updateStudentNameByEmailId("Aditya", "nitesh@gmail.com");	
	}

}
