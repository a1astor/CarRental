package com.pac.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pac.model.Car;


@Repository
public interface CarRepository extends CrudRepository<Car, Long>, JpaSpecificationExecutor<Car> {
}

