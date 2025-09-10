package com.app.service;

import java.util.List;

import com.app.dtos.ApiResponse;
import com.app.dtos.CourseDto;
import com.app.dtos.CourseResponseDto;

public interface CourseInterface {

	ApiResponse addCourse(CourseDto dto);
	ApiResponse updateCourse(Long id, CourseDto dto);
	ApiResponse deleteCourse(Long id);
	List<CourseResponseDto> getAllCourses();
	CourseResponseDto getCourseDetails(Long id);
	
}
