package com.onegeneration.anything.imageservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.onegeneration.anything.imageservice.dtos.ImageResponseDTO;
import com.onegeneration.anything.imageservice.service.ImageService;

@RestController
@RequestMapping("api/images")
public class ImageServiceController {

	private final ImageService imageService;
	public ImageServiceController(final ImageService imageService) {
		this.imageService = imageService;
	}
	
	@GetMapping("/{itemId}")
	public List<ImageResponseDTO> getImagesForItem(@PathVariable String itemId){
		return imageService.getAllByItemId(itemId);
	}
	
	@PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, String itemId) throws Exception {
		ImageResponseDTO response = imageService.uploadImage(file, itemId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}
