package com.app.service;

import com.app.dtos.ApiResponse;
import com.app.dtos.SubjectAddDto;
import com.app.dtos.SubjectResponseDto;

public interface SubjectInterface {

	ApiResponse addSubject(Long courseId,SubjectAddDto dto);
	SubjectResponseDto fetchSubjectDetails(Long subjectId);
}
