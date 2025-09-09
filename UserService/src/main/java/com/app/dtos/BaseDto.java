package com.app.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseDto {

	//@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	//@JsonProperty(access = Access.READ_ONLY)
	private LocalDate creationDate;
	//@JsonProperty(access = Acces`s.READ_WRITE)
	private LocalDateTime updatedOn;
}
