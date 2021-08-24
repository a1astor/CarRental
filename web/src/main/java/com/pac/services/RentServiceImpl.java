package com.pac.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pac.dao.UserRepository;
import com.pac.exceptions.CanNotCreateContractException;
import com.pac.exceptions.NoSuchUserException;
import com.pac.model.Car;
import com.pac.model.Contract;
import com.pac.model.User;

@Service
public class RentServiceImpl implements RentService {

    private CarService carService;
    private ContractService contractService;
    private UserRepository userRepository;

    @Autowired
    public RentServiceImpl(CarService carService, ContractService contractService, UserRepository userRepository) {
        this.carService = carService;
        this.contractService = contractService;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Contract rent(long carId, Date startDate, Date endDate, long userId) {
        final Date contractCreatedDate = new Date();
        final Car car = carService.findById(carId);
        if (car.isRented()) {
            throw new CanNotCreateContractException();
        }

        final User user = userRepository.findById(userId).orElseThrow(NoSuchUserException::new);
        car.setRented(true);
        return contractService.createNewContract(car, startDate, endDate, contractCreatedDate, user);
    }

}
