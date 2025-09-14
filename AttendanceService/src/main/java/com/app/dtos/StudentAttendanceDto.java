package com.app.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class StudentAttendanceDto extends BaseDto {

	private Long rollNumber;
	private String name;
	private String status;
}
