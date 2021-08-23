package com.pac.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pac.exceptions.CanNotCreateContractException;
import com.pac.model.Car;
import com.pac.model.Contract;

@Service
public class RentServiceImpl implements RentService {

    private CarService carService;
    private ContractService contractService;

    @Autowired
    public RentServiceImpl(CarService carService, ContractService contractService) {
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
