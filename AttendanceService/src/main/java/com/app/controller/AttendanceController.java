package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.StudentAttendanceRequestDto;
import com.app.service.AttendanceInterface;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/attendance")
@Validated
@AllArgsConstructor
public class AttendanceController {
	
	private final AttendanceInterface service;
	
	@PostMapping
	public ResponseEntity<?> markAttendance(@RequestBody StudentAttendanceRequestDto dto)
	{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addAttendanceRecord(dto));
	}
}
