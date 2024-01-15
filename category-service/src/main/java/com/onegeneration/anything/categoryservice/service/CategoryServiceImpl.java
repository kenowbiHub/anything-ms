package com.onegeneration.anything.categoryservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.onegeneration.anything.categoryservice.dto.CategoryResponseDTO;
import com.onegeneration.anything.categoryservice.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;
	public CategoryServiceImpl(final CategoryRepository categoryRepository,final ModelMapper modelMapper) {
		this.categoryRepository = categoryRepository;
		this.modelMapper = modelMapper;
	}
	@Override
	public List<CategoryResponseDTO> findAll() {
		return categoryRepository
				.findAll()
				.stream()
				.map(category->modelMapper.map(category, CategoryResponseDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryResponseDTO findByCategoryId(String categoryId) {
		return modelMapper.map(categoryRepository.findByCategoryId(categoryId), CategoryResponseDTO.class);
	}
	@Override
	public CategoryResponseDTO findCategoryByName(String name) {
		return modelMapper.map(categoryRepository.findCategoryByName(name), CategoryResponseDTO.class);
	}
}
