package com.pac.services;

import java.util.List;

import com.pac.exceptions.NoSuchCarException;
import com.pac.model.Car;
import com.pac.model.utilsclass.CarDTO;

public interface CarService {

    Car findById(Long id) throws NoSuchCarException;

    Iterable<Car> findAll();

    void deleteById(Long id);

    List<Car> findByParam(CarDTO carDTO);
}
