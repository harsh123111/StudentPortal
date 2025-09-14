package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dtos.ApiResponse;
import com.app.dtos.StudentAttendanceRequestDto;

public interface AttendanceInterface {

	ApiResponse addAttendanceRecord(StudentAttendanceRequestDto dto);
	//ApiResponse updateAttendanceBySubjectAndRollAndDate(Long subjectId,Long rollNumber,LocalDate date);
	List<StudentAttendanceRequestDto> fetchAttendanceBySubjectAndDate(String subject, LocalDate date);
	List<StudentAttendanceRequestDto> attendanceBySubjectId(Long subjectId);
	StudentAttendanceRequestDto attendanceByRollNumberAndSubjectIdAndDate(Long rollNumber, Long subjectId, LocalDate date);
}
