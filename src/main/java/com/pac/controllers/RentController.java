package com.pac.controllers;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac.exceptions.CanNotCreateContractException;
import com.pac.model.Contract;
import com.pac.model.utilsclass.RentDTO;
import com.pac.services.Impl.RentServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@Controller
@RequestMapping("api/contract")
public class RentController {

    private RentServiceImpl rentService;

    @Autowired
    public RentController(RentServiceImpl rentService) {
        this.rentService = rentService;
    }


    @NotNull
    @ApiOperation(value = "rent car for date")
    @PutMapping
    public Contract rentCar(@RequestBody RentDTO rentDTO) throws CanNotCreateContractException {
        return rentService.rent(rentDTO.getCarId(),rentDTO.getStartDate(),rentDTO.getEndDate());
    }
}
