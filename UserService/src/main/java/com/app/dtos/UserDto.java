package com.app.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class UserDto extends BaseDto {

	private String name;
	private String email;
	private String role;
}
