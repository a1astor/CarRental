package com.pac.dao;

import org.springframework.data.repository.CrudRepository;

import com.pac.model.Address;


public interface AddressRepository extends CrudRepository<Address, Long> {
}
