package com.pac.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pac.dao.CarRepository;
import com.pac.exceptions.NoSuchCarException;
import com.pac.model.Car;
import com.pac.services.CarService;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car findById(Long id) throws NoSuchCarException {
        return carRepository.findById(id).orElseThrow(NoSuchCarException::new);
    }

    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

//    public List<Car> getNotRentedCars() {
//        return carRepository.getCarsByRentedFalse();
//    }
}
