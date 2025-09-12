package com.app.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class StudentDto extends UserDto {

	private Long rollNumber;
	private String department;
	
}
