package com.onegeneration.anything.itemservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onegeneration.anything.itemservice.clients.CategoryRestClient;
import com.onegeneration.anything.itemservice.dtos.ItemRequestDTO;
import com.onegeneration.anything.itemservice.dtos.ItemResponseDTO;
import com.onegeneration.anything.itemservice.service.ItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/items")
public class ItemController {

	private final ItemService itemService;
	private final CategoryRestClient categoryRestClient;
	
	public ItemController(final ItemService itemService,final CategoryRestClient itemRestClient) {
		this.itemService = itemService;
		this.categoryRestClient = itemRestClient;
	}
	
	@GetMapping
	public List<ItemResponseDTO> getAllItems(){
		/*
		 * Category category = categoryRestClient.findCategoryByName("Electronics");
		 * System.out.println(category);
		 */
		return this.itemService.getAllItems();
	}
	
	@GetMapping("/{ownerId}")
	public List<ItemResponseDTO> getAllItemsForOwner(@PathVariable String ownerId,String categoryId){
		return this.itemService.getAllItemsForOwner(ownerId);
	}
	@PostMapping
	public void createItem(@RequestBody ItemRequestDTO itemRequestDTO) {
		//Category category = this.itemRestClient.findCategoryByName("cat1");
		//System.out.println(category);
	}
}
