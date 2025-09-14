package com.app.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class BulkAttendanceDto extends BaseDto {

	private Long subjectId;	
	
	private LocalDate date;
	
	private String session;
	private List<StudentAttendanceDto> records=new ArrayList<>();
}
