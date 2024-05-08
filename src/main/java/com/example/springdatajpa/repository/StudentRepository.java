package com.example.springdatajpa.repository;

import org.springframework.stereotype.Repository;

import com.example.springdatajpa.entity.Student;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	
// --------------------------------
// --------- JPA Queries ----------
//  -------------------------------
	
//	findByfirstName as variable in Student.java is firstName and the func ends with var name
	List<Student> findByFirstName(String firstName);
	
	List<Student> findByFirstNameContaining(String name);

	List<Student> findByLastNameNotNull();
	
//	findByGuardianName as variable in Student.java is guardian and variable in Guardian.java is name
	List<Student> findByGuardianName(String guardianName);
	
	Student findByFirstNameAndLastName(String firstName,String lastName);
	
// --------------------------------
// --------- JPQL Query -----------
//  -------------------------------

//	-----------------> Read
	
//	Student as JPQL is based on Classes & Attributes with which we have defined not on the basis of Table Name or Column Names
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String emailId);
	
	@Query("select s.firstName from Student s where s.emailId = ?1")
	String getStudentFirstNameByEmailAddress(String emailId);
	
	@Query(value="select * from tbl_student s where s.email_address = ?1",nativeQuery = true)
	Student getStudentByEmailAddressNative(String emailId);
	
	@Query(value="select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
	Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
	
//	-----------------> Update
	
	@Modifying // As this method modifies values in the DB
	@Transactional // As we want entire transaction is committed in DB at once. If it fails before then nothing is committed
	@Query(value="update tbl_student set first_name = ?1 where email_address = ?2",nativeQuery = true)
	int updateStudentNameByEmailId(String firstName,String emailId);
	
	
	
}
