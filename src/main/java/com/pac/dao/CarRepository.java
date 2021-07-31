package com.pac.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pac.model.Car;

@Repository
@Qualifier("carRepositoryImpl")
public interface CarRepository extends CrudRepository<Car, Long> {


    Car getCarById(long id);
}
