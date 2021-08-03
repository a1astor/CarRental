package com.pac.controllers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac.exceptions.NoSuchCarException;
import com.pac.model.Address;
import com.pac.services.AddressService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @ApiOperation(value = "Find all address")
    @RequestMapping("/")
    public Iterable<Address> findAll() {
        return addressService.findAll();
    }

    @Pattern(regexp = "#^[0-9]+$#")
    @NotNull
    @ApiOperation(value = "Find address by id")
    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) throws NoSuchCarException {
        return addressService.findById(id);
    }
}
