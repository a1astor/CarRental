package com.pac.services;

import com.pac.exceptions.NoSuchCarException;
import com.pac.model.Car;

public interface CarService {

    Car findById(Long id) throws NoSuchCarException;

    Iterable<Car> findAll();

    void deleteById(Long id);
}
