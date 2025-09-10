package com.app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class CourseDto {

	private String title;
	private String description;
	
	public CourseDto(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
	
}
