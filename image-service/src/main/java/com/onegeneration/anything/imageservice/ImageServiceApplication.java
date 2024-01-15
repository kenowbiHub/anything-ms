package com.onegeneration.anything.imageservice;

import java.util.HexFormat;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.onegeneration.anything.imageservice.entity.Image;
import com.onegeneration.anything.imageservice.repository.ImageRepository;

@SpringBootApplication
public class ImageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(ImageRepository imageRepository) {
		return args ->{
			Image img = Image
					.builder()
					.contentType("image/png")
					.imageId(UUID.randomUUID().toString())
					.imageData(HexFormat.of().parseHex("e04fd020ea3a6910a2d808002b30309d"))
					.itemId(UUID.randomUUID().toString())
					.name("image")
					.build();
			imageRepository.save(img);
		};
	}
}
