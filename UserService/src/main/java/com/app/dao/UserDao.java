package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {

	List<UserEntity> findByRole(String role);
	Optional<UserEntity> findByRollNumber(Long rollNumber);
}
