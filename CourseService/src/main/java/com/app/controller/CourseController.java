package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.CourseDto;
import com.app.dtos.CourseResponseDto;
import com.app.service.CourseInterface;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/courses")
@Validated
@AllArgsConstructor
public class CourseController {

	private CourseInterface courseService;
	
	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody CourseDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(courseService.addCourse(dto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCourses()
	{
		List<CourseResponseDto> allCourses = courseService.getAllCourses();
		if(allCourses.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(allCourses);
	}
	
	@GetMapping("/{courseId}")
	public ResponseEntity<?> getCourseDetails(@PathVariable Long courseId)
	{
		return ResponseEntity.ok(courseService.getCourseDetails(courseId));
	}
}
