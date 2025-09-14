package com.app.service;

import java.util.List;

import com.app.dtos.ApiResponse;
import com.app.dtos.FacultyAddDto;
import com.app.dtos.FacultyDto;
import com.app.dtos.StudentAddDto;
import com.app.dtos.StudentDto;
import com.app.dtos.StudentUpdateDto;

public interface UserServiceInterface {

	
	ApiResponse addStudent(StudentAddDto dto);
	//update by roll
	ApiResponse updateStudent(Long rollNumber, StudentUpdateDto dto);
	ApiResponse deleteStudent(Long userId);
	//findByRollNumber
	StudentDto getStudentDetails(Long rollNumber);
	List<StudentDto> getAllStudents(String role);
	
	ApiResponse addFaculty(FacultyAddDto dto);
	List<FacultyDto> getAllFaculties(String role);
	FacultyDto getFacultyDetails(Long facultyId);
	
}
