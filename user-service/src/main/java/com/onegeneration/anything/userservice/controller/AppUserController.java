package com.onegeneration.anything.userservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onegeneration.anything.userservice.dtos.AppUserResponseDTO;
import com.onegeneration.anything.userservice.service.AppUserService;

@RestController
@RequestMapping("api/users")
public class AppUserController {
	private final AppUserService userService;

	public AppUserController(final AppUserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<AppUserResponseDTO> getUserList() {
		return userService.findAllUsers();
	}
	@GetMapping("/{id}")
	public AppUserResponseDTO getUser(@PathVariable Long id) {
		return userService.findById(id);
	}
}
