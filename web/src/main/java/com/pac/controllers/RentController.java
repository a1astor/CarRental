package com.pac.controllers;

import com.pac.exceptions.CanNotCreateContractException;
import com.pac.exceptions.WrongDateFormatException;
import com.pac.model.Contract;
import com.pac.model.utilsclass.RentDTO;
import com.pac.services.RentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Controller
@RequestMapping("api/contract")
public class RentController {

    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }


    @NotNull
//    @PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "rent car for date")
    @PutMapping
    public Contract rentCar(@Valid @RequestBody RentDTO rentDTO) throws CanNotCreateContractException {
        Date startDate;
        Date endDate;
        try {
            startDate = new SimpleDateFormat("dd/MM/yyyy").parse(rentDTO.getStartDate());
            endDate = new SimpleDateFormat("dd/MM/yyyy").parse(rentDTO.getEndDate());
        } catch (Exception e) {
            throw new WrongDateFormatException();
        }
        return rentService.rent(rentDTO.getCarId(), startDate, endDate);
    }
}
