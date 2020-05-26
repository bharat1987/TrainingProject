package com.msproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msproject.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByUserId(String userId);

}
