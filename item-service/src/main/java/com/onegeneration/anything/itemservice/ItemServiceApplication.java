package com.onegeneration.anything.itemservice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.onegeneration.anything.itemservice.clients.CategoryRestClient;
import com.onegeneration.anything.itemservice.entity.Address;
import com.onegeneration.anything.itemservice.entity.Cardinality;
import com.onegeneration.anything.itemservice.entity.Item;
import com.onegeneration.anything.itemservice.entity.ItemStatus;
import com.onegeneration.anything.itemservice.model.Category;
import com.onegeneration.anything.itemservice.repository.AddressRepository;
import com.onegeneration.anything.itemservice.repository.ItemRepository;

@SpringBootApplication
@EnableFeignClients
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(final ItemRepository itemRepository, final AddressRepository addressRepository,final CategoryRestClient categoryRestClient) {
		return args -> {
			Address address = Address
					.builder()
					.cardinality(Cardinality.NORTH_EAST)
					.city("Calgary")
					.postalCode("T2E 4X6")
					.street("19 ST")
					.build();
			addressRepository.save(address);
			
		Category category =	categoryRestClient.findCategoryByName("Electronics");
			Item item1 = Item.
					builder()
					.categoryId(category.getCategoryId())
					.createdAt(LocalDateTime.now())
					.description("Used iphone 13")
					.itemId(UUID.randomUUID().toString())
					.location(address)
					.name("Iphone 13")
					.ownerId(UUID.randomUUID().toString())
					.price(BigDecimal.valueOf(1499.99))
					.status(ItemStatus.OPEN)
					.build();
			Item item = Item.
					builder()
					.categoryId(category.getCategoryId())
					.createdAt(LocalDateTime.now())
					.description("Brand new iphone 13")
					.itemId(UUID.randomUUID().toString())
					.location(address)
					.name("Iphone 13")
					.ownerId(UUID.randomUUID().toString())
					.price(BigDecimal.valueOf(1499.99))
					.status(ItemStatus.OPEN)
					.build();
			category = categoryRestClient.findCategoryByName("Real Estate");
			Item item2 = Item.
					builder()
					.categoryId(category.getCategoryId())
					.createdAt(LocalDateTime.now())
					.description("Real Estate")
					.itemId(UUID.randomUUID().toString())
					.location(address)
					.name("Two bedroom apartment")
					.ownerId(UUID.randomUUID().toString())
					.price(BigDecimal.valueOf(1800.99))
					.status(ItemStatus.OPEN)
					.build();
		itemRepository.saveAll(List.of(item,item1,item2));	
		};
	}
}
