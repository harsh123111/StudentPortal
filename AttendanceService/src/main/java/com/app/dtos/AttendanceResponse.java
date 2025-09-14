package com.app.dtos;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class AttendanceResponse extends BaseDto {

	private String rollNumber;
    private Long subjectId;
    private LocalDate date;
    private String session;
    private String status;
}
