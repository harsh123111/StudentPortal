package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.UserAddDto;
import com.app.dtos.UserResponseDto;
import com.app.service.UserServiceInterface;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@Validated
@AllArgsConstructor
public class UserController {

	private final UserServiceInterface userService;
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody UserAddDto dto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(dto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUser()
	{
		List<UserResponseDto> allUsers = userService.getAllUsers();
		if(allUsers.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserDetails(@PathVariable Long userId)
	{
		return ResponseEntity.ok(userService.getUserDetails(userId));
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUserDetails(@PathVariable Long userId, @RequestBody UserAddDto dto)
	{
		return ResponseEntity.ok(userService.updateUser(userId,dto));
	}
}
