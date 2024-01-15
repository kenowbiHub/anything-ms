package com.onegeneration.anything.categoryservice.service;

import java.util.List;

import com.onegeneration.anything.categoryservice.dto.CategoryResponseDTO;

public interface CategoryService {

	List<CategoryResponseDTO> findAll();

	CategoryResponseDTO findByCategoryId(String id);
	
	CategoryResponseDTO findCategoryByName(String name);

}
