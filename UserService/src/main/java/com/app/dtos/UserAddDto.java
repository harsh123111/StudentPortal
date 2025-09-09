package com.app.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddDto 
{
	private String name;
	private String email;
	private String password;
	private String role;
}
