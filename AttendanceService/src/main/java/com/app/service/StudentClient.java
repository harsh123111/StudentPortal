package com.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.dtos.StudentDto;

@FeignClient("UserService")
public interface StudentClient {

	@GetMapping("/users/student/{rollNumber}")
	StudentDto getUserDetails(@PathVariable Long rollNumber);
}
