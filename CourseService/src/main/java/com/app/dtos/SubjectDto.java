package com.app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class SubjectDto extends BaseDto {

	private String subjectTitle;
	private String description;
	
	
	public SubjectDto(String subjectTitle, String description) {
		super();
		this.subjectTitle = subjectTitle;
		this.description = description;
	}
	
	
}
