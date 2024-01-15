package com.onegeneration.anything.categoryservice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.onegeneration.anything.categoryservice.config.GlobalConfig;
import com.onegeneration.anything.categoryservice.entity.Category;
import com.onegeneration.anything.categoryservice.repository.CategoryRepository;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CategoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CategoryRepository categoryRepository) {
		return args ->{
			Category category1 = Category
					.builder()
					.name("Electronics")
					.categoryId("cat1")
					.description("Electronic Devices")
					.build();
			Category category2 = Category
					.builder()
					.name("Real Estate")
					.categoryId("cat2")
					.description("Real Estate")
					.build();
			Category category3 = Category
					.builder()
					.name("Cars")
					.categoryId("cat3")
					.description("Cars")
					.build();
			categoryRepository.saveAll(List.of(category1,category2,category3));
		};
	}
}
