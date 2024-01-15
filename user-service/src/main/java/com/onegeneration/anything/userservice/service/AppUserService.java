package com.onegeneration.anything.userservice.service;

import java.util.List;

import com.onegeneration.anything.userservice.dtos.AppUserResponseDTO;

public interface AppUserService {
	
	List<AppUserResponseDTO> findAllUsers();
	AppUserResponseDTO findById(Long id);
}
