package com.onegeneration.anything.userservice;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.onegeneration.anything.userservice.entity.AppUser;
import com.onegeneration.anything.userservice.repository.AppUserRepository;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(AppUserRepository repository) {
		return args ->{
		AppUser user1 =	AppUser.builder()
			.email("user1@gmail.com")
			.firstName("First Name")
			.lastName("Last Name")
			.password("1234")
			.build();
			AppUser user2 =	AppUser.builder()
					.email("user2@gmail.com")
					.firstName("First Name2")
					.lastName("Last Name2")
					.password("12345")
					.build();
			repository.saveAll(List.of(user1,user2));
		};
	}
}
