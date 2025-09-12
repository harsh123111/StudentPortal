package com.app.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class StudentUpdateDto  {

	private String name;
	private String email;
	private String password;
	//private Long rollNumber;
	private String department;
}
