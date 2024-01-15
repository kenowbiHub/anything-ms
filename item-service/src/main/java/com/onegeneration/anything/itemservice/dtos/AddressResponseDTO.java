package com.onegeneration.anything.itemservice.dtos;

import com.onegeneration.anything.itemservice.entity.Cardinality;

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
public class AddressResponseDTO {
	
	private Long id;
	private String street;
	private String city;
	private String postalCode;
	private Cardinality cardinality;
}
