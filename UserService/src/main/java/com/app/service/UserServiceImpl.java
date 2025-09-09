package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.ApiResponse;
import com.app.dtos.UserAddDto;
import com.app.dtos.UserResponseDto;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInterface {

	@Override
	public ApiResponse addUser(UserAddDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse updateUser(Long userId, UserAddDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deleteUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponseDto getUserDetails(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserResponseDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
