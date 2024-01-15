package com.onegeneration.anything.imageservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.onegeneration.anything.imageservice.dtos.ImageResponseDTO;

public interface ImageService {
	List<ImageResponseDTO> getAllByItemId(String itemId);
	ImageResponseDTO uploadImage(MultipartFile file, String itemId)throws Exception;
}
