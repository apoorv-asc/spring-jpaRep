package com.example.springdatajpa.repository;

import org.springframework.stereotype.Repository;

import com.example.springdatajpa.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
