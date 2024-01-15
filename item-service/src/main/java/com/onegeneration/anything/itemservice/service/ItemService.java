package com.onegeneration.anything.itemservice.service;

import java.util.List;

import com.onegeneration.anything.itemservice.dtos.ItemResponseDTO;

public interface ItemService {
	
	List<ItemResponseDTO> getAllItems();
	List<ItemResponseDTO> getAllItemsForOwner(String ownerId);
}
