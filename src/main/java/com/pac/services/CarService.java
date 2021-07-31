package com.pac.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pac.dao.CarRepository;
import com.pac.exceptions.NoSuchCarException;
import com.pac.model.Car;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(@Qualifier("carRepositoryImpl") CarRepository carRepository) {
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
}
