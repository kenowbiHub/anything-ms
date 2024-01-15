package com.onegeneration.anything.itemservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onegeneration.anything.itemservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
	
	List<Item> findByOwnerId(String ownerId);

}
