package com.example.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdatajpa.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
