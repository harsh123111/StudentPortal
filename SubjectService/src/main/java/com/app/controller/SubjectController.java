package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.SubjectAddDto;
import com.app.service.SubjectInterface;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/subjects")
@AllArgsConstructor
@Validated
public class SubjectController {
	
	private final SubjectInterface service;
	
	@PostMapping("/{courseId}")
	public ResponseEntity<?> addSubject(@PathVariable Long courseId,@RequestBody SubjectAddDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addSubject(courseId, dto));
	}
	
	@GetMapping("/{subjectId}")
	public ResponseEntity<?> fetchSubject(@PathVariable Long subjectId)
	{
		return ResponseEntity.ok(service.fetchSubjectDetails(subjectId));
	}
}
