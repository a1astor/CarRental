package com.pac.controllers;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pac.exceptions.NoSuchCarException;
import com.pac.model.Car;
import com.pac.services.CarService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @ApiOperation(value = "Find all cars")
    @GetMapping("/")
    public Iterable<Car> findAll() {
        return carService.findAll();
    }

    @Pattern(regexp = "#^[0-9]+$#")
    @NotNull
    @ApiOperation(value = "Find car by id")
    @GetMapping("/{id}")
    public Car findCar(@PathVariable Long id) throws NoSuchCarException {
        return carService.findById(id);
    }

//    @NotNull
//    @ApiOperation(value = "Find city by name")
//    @GetMapping("/byName{name}")
//    public City findCityByName(@PathVariable String name) {
//        return citiesService.findByName(name);
//    }

//    @NotBlank
//    @NotNull
//    @ApiOperation(value = "add car")
//    @PostMapping("/save")
//    public Car addCar( ) {
//        return carService.save(name);
//    }

//    @NotBlank
//    @NotNull
//    @ApiOperation(value = "Remove city")
//    @Transactional
//    @DeleteMapping("/{id}")
//    public void removeCar(@PathVariable Long name) {
//        carService.deleteById(id);
//    }

    @Pattern(regexp = "#^[0-9]+$#")
    @NotNull
    @ApiOperation(value = "Remove car by id")
    @Transactional
    @DeleteMapping("/{id}")
    public void removeCarById(@PathVariable Long id) {
        carService.deleteById(id);
    }

}
