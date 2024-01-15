package com.onegeneration.anything.imageservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onegeneration.anything.imageservice.dtos.ImageResponseDTO;
import com.onegeneration.anything.imageservice.entity.Image;
import com.onegeneration.anything.imageservice.repository.ImageRepository;
import com.onegeneration.anything.imageservice.utils.ImageUtil;

@Service
public class ImageServiceImpl implements ImageService {
	private final ImageRepository imageRepository;
	private final ModelMapper modelMapper;

	public ImageServiceImpl(final ImageRepository imageRepository, final ModelMapper modelMapper) {
		this.imageRepository = imageRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ImageResponseDTO> getAllByItemId(String itemId) {
		List<Image> images = imageRepository.findByItemId(itemId);
		return images.stream().map(image -> modelMapper.map(image, ImageResponseDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ImageResponseDTO uploadImage(MultipartFile file, String itemId) throws Exception {
		Image savedImage = imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .contentType(file.getContentType())
                .itemId(itemId)
                .imageData(ImageUtil.compressImage(file.getBytes())).build());
        return modelMapper.map(savedImage, ImageResponseDTO.class); 
	}
}
