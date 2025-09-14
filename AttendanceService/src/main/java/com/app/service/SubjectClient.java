package com.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.dtos.SubjectResponseDto;

@FeignClient("SubjectService")
public interface SubjectClient {

	@GetMapping("/subjects/{subjectId}")
	SubjectResponseDto fetchSubject(@PathVariable Long subjectId);
}
