package com.onegeneration.anything.itemservice.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.onegeneration.anything.itemservice.clients.CategoryRestClient;
import com.onegeneration.anything.itemservice.dtos.ItemResponseDTO;
import com.onegeneration.anything.itemservice.entity.Item;
import com.onegeneration.anything.itemservice.model.Category;
import com.onegeneration.anything.itemservice.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	private final ItemRepository itemRepository;
	private final ModelMapper modelMapper;
	private final CategoryRestClient categoryRestClient;
	public ItemServiceImpl(final ItemRepository itemRepository,final ModelMapper modelMapper,final CategoryRestClient categoryRestClient) {
		this.itemRepository = itemRepository;
		this.modelMapper = modelMapper;
		this.categoryRestClient= categoryRestClient;
	}
	
	@Override
	public List<ItemResponseDTO> getAllItems() {
		List<Item> items = itemRepository.findAll();
		List<ItemResponseDTO> itemResponseDTOs = new ArrayList<>();
		for (Item item : items) {
			Category category = categoryRestClient.findCategoryByCategoryId(item.getCategoryId());
			item.setCategory(category);
			itemResponseDTOs.add(modelMapper.map(item, ItemResponseDTO.class));
		}
		return itemResponseDTOs;
	}
	
	@Override
	public List<ItemResponseDTO> getAllItemsForOwner(String ownerId) {
		return itemRepository
		.findByOwnerId(ownerId)
		.stream()
		.map(item ->modelMapper.map(item, ItemResponseDTO.class)).toList();
	}
}
