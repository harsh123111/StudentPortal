package com.app.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class AttendanceRecord extends BaseEntity {

	private String title;
	private Long subjectId;
	private Long studentRoll;
	private LocalDate date;
	private String status;
}
