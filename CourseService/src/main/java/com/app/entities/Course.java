package com.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="courses_tbl")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Course extends BaseEntity {
	
	private String title;
	private String description;
	
	public Course(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	
	
	
}
