package com.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users_tbl")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class UserEntity extends BaseEntity {

	private String name;
	private String email;
	private String password;
	private String role;
	
	public UserEntity(String name, String email, String password, String role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
}
	
