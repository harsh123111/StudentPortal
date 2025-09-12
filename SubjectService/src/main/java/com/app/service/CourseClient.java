package com.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.dtos.CourseResponseDto;

@FeignClient("CourseService")
public interface CourseClient {

	@GetMapping("/courses/{courseId}")
	public CourseResponseDto getCourseDetails(@PathVariable Long courseId);
}
