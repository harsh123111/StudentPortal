package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "subjects", uniqueConstraints = @UniqueConstraint(columnNames = {"subject_name","course_id"}))
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Subject extends BaseEntity {

	@Column(name="subject_name")
	private String name;
	@Column(name="course_id")
	private Long courseId;
	
	public Subject(String name) {
		super();
		this.name = name;
	}
	
	
}
