package com.onegeneration.anything.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onegeneration.anything.userservice.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}
