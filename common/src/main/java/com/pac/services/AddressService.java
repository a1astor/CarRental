package com.pac.services;

import com.pac.model.Address;

public interface AddressService {

    Iterable<Address> findAll();

    Address findById(Long id);
}
