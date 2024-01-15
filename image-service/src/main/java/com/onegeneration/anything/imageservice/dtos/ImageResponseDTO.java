package com.onegeneration.anything.imageservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponseDTO {
	private Long id;
	private String itemId;
	private String name;
    private String contentType;
    private byte[] imageData;

}
