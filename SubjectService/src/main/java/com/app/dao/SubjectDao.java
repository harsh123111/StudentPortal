package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Subject;

public interface SubjectDao extends JpaRepository<Subject, Long> {

	List<Subject> findByCourseId(Long courseId);
	boolean existsByNameAndCourseId(String name, Long courseId);
}
