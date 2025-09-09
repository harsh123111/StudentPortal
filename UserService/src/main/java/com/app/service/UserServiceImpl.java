package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dtos.ApiResponse;
import com.app.dtos.UserAddDto;
import com.app.dtos.UserResponseDto;
import com.app.entities.UserEntity;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserServiceInterface {

	private final UserDao userDao;
	private final ModelMapper mapper;
	
	@Override
	public ApiResponse addUser(UserAddDto dto) {
		// TODO Auto-generated method stub
		UserEntity entity = mapper.map(dto, UserEntity.class);
		UserEntity userEntity = userDao.save(entity);
		return new ApiResponse("User created with id"+userEntity.getId());
	}

	@Override
	public ApiResponse updateUser(Long userId, UserAddDto dto) {
		// TODO Auto-generated method stub
		UserEntity entity = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		mapper.map(dto, entity);
		return new ApiResponse("user updated");
	}

	@Override
	public ApiResponse deleteUser(Long userId) {
		// TODO Auto-generated method stub
		UserEntity entity = userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
		userDao.delete(entity);
		return new ApiResponse("User deleted !!!!!");
	}

	@Override
	public UserResponseDto getUserDetails(Long userId) {
		// TODO Auto-generated method stub
		UserEntity user = userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		return mapper.map(user, UserResponseDto.class);
	}

	@Override
	public List<UserResponseDto> getAllUsers() {
		// TODO Auto-generated method stub
			List<UserEntity> list = userDao.findAll();
			
		return list.stream().map(item -> mapper.map(item, UserResponseDto.class)).toList();
	}

}
