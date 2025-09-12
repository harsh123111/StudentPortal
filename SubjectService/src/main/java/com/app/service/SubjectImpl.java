package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ApiException;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.SubjectDao;
import com.app.dtos.ApiResponse;
import com.app.dtos.CourseResponseDto;
import com.app.dtos.SubjectAddDto;
import com.app.dtos.SubjectResponseDto;
import com.app.entities.Subject;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class SubjectImpl implements SubjectInterface {
	
	private final ModelMapper mapper;
	private final SubjectDao dao;
	private final CourseClient client;
	@Override
	public ApiResponse addSubject(Long courseId, SubjectAddDto dto) {
		// TODO Auto-generated method stub
		//microservice call to Course service to fetch course details
		CourseResponseDto courseDetails = client.getCourseDetails(courseId);
		
		if(dao.existsByNameAndCourseId(dto.getName(), courseId)) throw new ApiException("duplicate course or subject found");
		Subject subject = mapper.map(dto, Subject.class);
		subject.setCourseId(courseId);
		dao.save(subject);
		return new ApiResponse("subject added to course");
	}
	@Override
	public SubjectResponseDto fetchSubjectDetails(Long subjectId) {
		// TODO Auto-generated method stub
		Subject subject = dao.findById(subjectId).orElseThrow(()-> new ResourceNotFoundException("subject not found"));
		
		return mapper.map(subject, SubjectResponseDto.class);
	}

}
