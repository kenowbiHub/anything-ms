package com.onegeneration.anything.itemservice.clients;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.onegeneration.anything.itemservice.model.Category;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@FeignClient(name="CATEGORY-SERVICE")
public interface CategoryRestClient {
	

@GetMapping("/api/categories/search")
@CircuitBreaker(name = "categoryService", fallbackMethod = "getDefaultCategory")
 Category findCategoryByName(@RequestParam(value="name") String name);

@GetMapping("/api/categories/{categoryId}")
@CircuitBreaker(name = "categoryService", fallbackMethod = "getDefaultCategoryById")
Category findCategoryByCategoryId(@PathVariable String categoryId);

@GetMapping("/api/categories")
@CircuitBreaker(name = "categoryService", fallbackMethod = "getDefaultAllCategories")
List<Category> allCategories();


	default Category getDefaultCategory(String name, Exception e) {
		return Category
				.builder()
				.categoryId("cat1")
				.description("Not available")
				.id(1L)
				.build();
	}
	
	default Category getDefaultCategoryById(String categoryId,Exception e) {
		return Category
				.builder()
				.categoryId(UUID.randomUUID().toString())
				.description("Not available")
				.id(1L)
				.build();
	}
	
	default List<Category> getDefaultAllCategories(Exception e){
		return List.of();
	}
}
