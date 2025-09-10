package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.CourseDao;
import com.app.dtos.ApiResponse;
import com.app.dtos.CourseDto;
import com.app.dtos.CourseResponseDto;
import com.app.entities.Course;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CourseImpl implements CourseInterface {
	
	private final CourseDao courseDao;
	private final ModelMapper mapper;

	@Override
	public ApiResponse addCourse(CourseDto dto) {
		// TODO Auto-generated method stub
		Course course = mapper.map(dto, Course.class);
		courseDao.save(course);
		return new ApiResponse("Course added with id = "+course.getId());
	}

	@Override
	public ApiResponse updateCourse(Long id, CourseDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deleteCourse(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseResponseDto> getAllCourses() {
		// TODO Auto-generated method stub
		List<Course> courses = courseDao.findAll();
		List<CourseResponseDto> list = courses.stream().map(item -> mapper.map(item, CourseResponseDto.class)).toList();
		return list;
	}

	@Override
	public CourseResponseDto getCourseDetails(Long id) {
		// TODO Auto-generated method stub
		 Course course = courseDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Course not found"));
		CourseResponseDto responseDto = mapper.map(course, CourseResponseDto.class);
		return responseDto;
	}

}
