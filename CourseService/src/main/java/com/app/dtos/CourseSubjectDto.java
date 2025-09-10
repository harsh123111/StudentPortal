package com.app.dtos;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class CourseSubjectDto extends BaseDto {
	
	private String title;
	private String description;
	private List<SubjectDto> subjectList=new ArrayList<>();
}
