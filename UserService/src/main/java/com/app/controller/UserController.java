package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.FacultyAddDto;
import com.app.dtos.FacultyDto;
import com.app.dtos.StudentAddDto;
import com.app.dtos.StudentDto;
import com.app.dtos.StudentUpdateDto;
import com.app.service.UserServiceInterface;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@Validated
@AllArgsConstructor
public class UserController {

	private final UserServiceInterface userService;
	
	@PostMapping("/student")
	public ResponseEntity<?> addStudent(@RequestBody StudentAddDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addStudent(dto));
	}
	
	@GetMapping("/students/{role}")
	public ResponseEntity<?> getAllStudents(@PathVariable String role)
	{
		List<StudentDto> allStudents = userService.getAllStudents(role);
		if(allStudents.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(allStudents);
	}
	
	
	@GetMapping("/student/{rollNumber}")
	public ResponseEntity<?> getUserDetails(@PathVariable Long rollNumber)
	{
		return ResponseEntity.ok(userService.getStudentDetails(rollNumber));
	}

	@PutMapping("/student/{rollNumber}")
	public ResponseEntity<?> updateUserDetails(@PathVariable Long rollNumber, @RequestBody StudentUpdateDto dto)
	{
		return ResponseEntity.ok(userService.updateStudent(rollNumber,dto));
	}
	
	@PostMapping("/faculties")
	public ResponseEntity<?> addFaculty(@RequestBody FacultyAddDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addFaculty(dto));
	}
	
	@GetMapping("/faculties/{role}")
	public ResponseEntity<?> getAllFaculties(@PathVariable String role)
	{
		List<FacultyDto> allFaculties = userService.getAllFaculties(role);
		if(allFaculties.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(allFaculties);
	}
}
