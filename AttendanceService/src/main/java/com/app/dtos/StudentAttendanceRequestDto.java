package com.app.dtos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class StudentAttendanceRequestDto {
	

	private Long subjectId;
	
	private Long rollNumber;
	
	private LocalDate date;
	
	private String session;
	private String status;
}
