package com.example.springdatajpa.repository;

import org.springframework.stereotype.Repository;

import com.example.springdatajpa.entity.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	
//	findByfirstName as variable in Student.java is firstName and the func ends with var name
	List<Student> findByFirstName(String firstName);
	
	List<Student> findByFirstNameContaining(String name);

	List<Student> findByLastNameNotNull();
	
//	findByGuardianName as variable in Student.java is guardian and variable in Guardian.java is name
	List<Student> findByGuardianName(String guardianName);
	
	Student findByFirstNameAndLastName(String firstName,String lastName);
	
}
