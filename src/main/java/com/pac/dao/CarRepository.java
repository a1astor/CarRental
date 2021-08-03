package com.pac.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pac.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Car getCarById(long id);

//    List<Car> getCarsByRentedFalse();
}

