package com.app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class CourseResponseDto extends BaseDto {

	private String title;
	private String description;
	
	public CourseResponseDto(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
	
}
