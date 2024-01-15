package com.onegeneration.anything.imageservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onegeneration.anything.imageservice.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	List<Image> findByItemId(String itemId);
}
