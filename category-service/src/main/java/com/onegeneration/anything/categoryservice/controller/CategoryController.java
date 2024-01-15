package com.onegeneration.anything.categoryservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onegeneration.anything.categoryservice.dto.CategoryResponseDTO;
import com.onegeneration.anything.categoryservice.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	private final CategoryService categoryService;
	public CategoryController(final CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public List<CategoryResponseDTO> allCategories(){
		return this.categoryService.findAll();
	}

	@GetMapping("/{categoryId}") 
	public CategoryResponseDTO categoryByCategoryId(@PathVariable String categoryId){ 
	return this.categoryService.findByCategoryId(categoryId); }
	 
	
	 @GetMapping("/search")
	public CategoryResponseDTO categoriesByName(@RequestParam(value="name") String name){
		return this.categoryService.findCategoryByName(name);
	}
}
