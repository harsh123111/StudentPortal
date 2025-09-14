package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AttendanceDao;
import com.app.dtos.ApiResponse;
import com.app.dtos.StudentAttendanceRequestDto;
import com.app.dtos.StudentDto;
import com.app.dtos.SubjectResponseDto;
import com.app.entities.AttendanceRecord;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AttendanceImpl implements AttendanceInterface {

	private final AttendanceDao dao;
	private final SubjectClient subjectClient;
	private final StudentClient studentClient;
	
	@Override
	public ApiResponse addAttendanceRecord(StudentAttendanceRequestDto dto) {
		// TODO Auto-generated method stub
		//here you need student and subject details so call student and subject miroservice
		SubjectResponseDto subjectResponseDto = subjectClient.fetchSubject(dto.getSubjectId());
		
		StudentDto studentDto = studentClient.getUserDetails(dto.getRollNumber());
		
		Optional<AttendanceRecord> existingRecord = dao.findByRollNumberAndSubjectIdAndDateAndSession(studentDto.getRollNumber(), dto.getSubjectId(), dto.getDate(), dto.getSession());
		
		AttendanceRecord record;
		if(existingRecord.isPresent())
		{
			record=existingRecord.get();
			record.setDate(LocalDate.now());
			record.setStatus(dto.getStatus());
		}
		else
		{
			record=new AttendanceRecord();
			record.setRollNumber(studentDto.getRollNumber());
			record.setSubjectId(dto.getSubjectId());
			record.setDate(dto.getDate());
			record.setSession(dto.getSession());
			record.setStatus(dto.getStatus());		
		}
		dao.save(record);
		return new ApiResponse("attendance added student roll = "+record.getRollNumber());
	}

	@Override
	public List<StudentAttendanceRequestDto> fetchAttendanceBySubjectAndDate(String subject, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentAttendanceRequestDto> attendanceBySubjectId(Long subjectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentAttendanceRequestDto attendanceByRollNumberAndSubjectIdAndDate(Long rollNumber, Long subjectId,
			LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

}
