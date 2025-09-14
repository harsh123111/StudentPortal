package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dtos.ApiResponse;
import com.app.dtos.FacultyAddDto;
import com.app.dtos.FacultyDto;
import com.app.dtos.StudentAddDto;
import com.app.dtos.StudentDto;
import com.app.dtos.StudentUpdateDto;
import com.app.entities.UserEntity;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

	private final UserDao userDao;
	private final ModelMapper mapper;
	
	
	@Override
	public ApiResponse addStudent(StudentAddDto dto) {
		// TODO Auto-generated method stub
		UserEntity entity = mapper.map(dto, UserEntity.class);
		entity.setRole("STUDENT");
		UserEntity userEntity = userDao.save(entity);
		return new ApiResponse("User created with id"+userEntity.getId());
	}
	
	@Override
	public List<StudentDto> getAllStudents(String role)
	{
		List<UserEntity> list = userDao.findByRole(role);
		List<StudentDto> map = list.stream().map(item -> mapper.map(item, StudentDto.class)).toList();
		return map;
	}

	@Override
	public ApiResponse updateStudent(Long rollNumber, StudentUpdateDto dto) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findByRollNumber(rollNumber).orElseThrow(()->new ResourceNotFoundException("wrong roll number"));
		mapper.map(dto, userEntity);
		return new ApiResponse("student updated ");
	}

	@Override
	public ApiResponse deleteStudent(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentDto getStudentDetails(Long rollNumber) {
		// TODO Auto-generated method stub
		UserEntity entity = userDao.findByRollNumber(rollNumber).orElseThrow(()-> new ResourceNotFoundException("Wrong rollNumber"));
		StudentDto studentDto = mapper.map(entity, StudentDto.class);
		return studentDto;
	}

	@Override
	public ApiResponse addFaculty(FacultyAddDto dto) {
		// TODO Auto-generated method stub
		UserEntity userEntity = mapper.map(dto, UserEntity.class);
		userEntity.setRole("FACULTY");
		userDao.save(userEntity);
		return new ApiResponse("faculty added with id = "+userEntity.getId());
	}

	@Override
	public List<FacultyDto> getAllFaculties(String role) {
		// TODO Auto-generated method stub
		List<UserEntity> list = userDao.findByRole(role);
		List<FacultyDto> dtoList = list.stream().map(item->mapper.map(item, FacultyDto.class)).toList();
		return dtoList;
	}

	@Override
	public FacultyDto getFacultyDetails(Long facultyId) {
		// TODO Auto-generated method stub
		UserEntity userEntity = userDao.findById(facultyId).orElseThrow(()-> new ResourceNotFoundException("faculty not found"));
		FacultyDto dto = mapper.map(userEntity, FacultyDto.class);
		return dto;
	}

}
