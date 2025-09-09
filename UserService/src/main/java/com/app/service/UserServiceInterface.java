package com.app.service;

import java.util.List;

import com.app.dtos.ApiResponse;
import com.app.dtos.UserAddDto;
import com.app.dtos.UserResponseDto;

public interface UserServiceInterface {

	ApiResponse addUser(UserAddDto dto);
	ApiResponse updateUser(Long userId, UserAddDto dto);
	ApiResponse deleteUser(Long userId);
	UserResponseDto getUserDetails(Long userId);
	List<UserResponseDto> getAllUsers();
}
