package com.onegeneration.anything.itemservice.dtos;

import java.math.BigDecimal;

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
public class ItemRequestDTO {
	private String itemId;
	private BigDecimal price;
	private String category;
	private String name;
	private String description;
	private String ownerId;// logged in user
	private String street;
	private String city;
	private String postalCode; 

}
