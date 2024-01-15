package com.onegeneration.anything.categoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onegeneration.anything.categoryservice.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findByCategoryId(String categoryId);
	Category findCategoryByName(String name);

}
