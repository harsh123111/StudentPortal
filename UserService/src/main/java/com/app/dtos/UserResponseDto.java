package com.app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class UserResponseDto extends BaseDto {

	private String name;
	private String email;
	private String role;
	public UserResponseDto(String name, String email, String role) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
	}
	
	
}
