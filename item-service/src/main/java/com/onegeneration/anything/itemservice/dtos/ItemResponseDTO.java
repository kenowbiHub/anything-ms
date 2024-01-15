package com.onegeneration.anything.itemservice.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.onegeneration.anything.itemservice.entity.ItemStatus;
import com.onegeneration.anything.itemservice.model.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDTO {
	
	private String itemId;
	private BigDecimal price;
	private String categoryId;
	private String name;
	private String description;
	private LocalDateTime createdAt;
	private ItemStatus status;
	private String ownerId;
	private AddressResponseDTO addressResponseDTO;
	private Category category;

}
