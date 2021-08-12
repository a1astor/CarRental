package com.pac.services.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pac.exceptions.CanNotCreateContractException;
import com.pac.model.Car;
import com.pac.model.Contract;
import com.pac.services.CarService;
import com.pac.services.RentService;

@Service
public class RentServiceImpl implements RentService {

    private CarService carService;
    private ContractServiceImpl contractService;

    @Autowired
    public RentServiceImpl(CarService carService, ContractServiceImpl contractService) {
        this.carService = carService;
        this.contractService = contractService;
    }

    @Transactional
    public Contract rent(long carId, Date startDate, Date endDate) {
        Date contractCreatedDate = new Date();
        Car car = carService.findById(carId);
        if (car.isRented()) {
            throw new CanNotCreateContractException();
        }

        car.setRented(true);
        return contractService.createNewContract(car, startDate, endDate, contractCreatedDate);
    }

}
