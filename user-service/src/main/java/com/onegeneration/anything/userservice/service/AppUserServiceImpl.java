package com.onegeneration.anything.userservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.onegeneration.anything.userservice.dtos.AppUserResponseDTO;
import com.onegeneration.anything.userservice.entity.AppUser;
import com.onegeneration.anything.userservice.repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {

	private final AppUserRepository repository;
	private final ModelMapper modelMapper;
	public AppUserServiceImpl(final AppUserRepository repository,final ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public List<AppUserResponseDTO> findAllUsers() {
		return repository
				.findAll()
				.stream()
				.map(user->modelMapper.map(user, AppUserResponseDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public  AppUserResponseDTO findById(Long id) {
		Optional<AppUser> optUser = repository.findById(id);
		return modelMapper.map(optUser.get(), AppUserResponseDTO.class); 
	}
}
