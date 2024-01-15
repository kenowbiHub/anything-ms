package com.onegeneration.anything.itemservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onegeneration.anything.itemservice.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
