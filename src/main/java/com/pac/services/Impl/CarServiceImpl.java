package com.pac.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pac.dao.CarRepository;
import com.pac.dao.ModelRepository;
import com.pac.exceptions.NoSuchCarException;
import com.pac.model.Car;
import com.pac.model.Model;
import com.pac.model.utilsclass.CarDTO;
import com.pac.services.CarService;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final ModelRepository modelRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelRepository modelRepository) {
        this.carRepository = carRepository;
        this.modelRepository = modelRepository;
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

    @Override
    public List<Car> findByParam(CarDTO carDTO) {
        Model model = carDTO.getModel();
        Long modelId = null;
        if (carDTO.getModel() != null) {
            modelId = modelRepository.getModelIdByMarkAndGenerationAndModel(model.getMark(), model.getGeneration(), model.getModel());
        }
        return carRepository.findAll(carDTO.getSpecification(modelId));
    }
}
