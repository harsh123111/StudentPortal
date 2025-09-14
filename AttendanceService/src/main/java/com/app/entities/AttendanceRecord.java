package com.app.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Table(name = "attendance_records")
public class AttendanceRecord extends BaseEntity {


	@Column(name = "subject_id", nullable = false)
	private Long subjectId;
	@Column(name = "roll_number", nullable = false)
	private Long rollNumber;
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(nullable = false)
	String session;
	@Column(nullable = false)
	private String status;
}
