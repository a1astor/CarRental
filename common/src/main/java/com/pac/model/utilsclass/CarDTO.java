package com.pac.model.utilsclass;

import java.util.Date;

import com.pac.model.Model;

import com.pac.model.CarBodyType;
import com.pac.model.TransmissionType;

import lombok.Data;

@Data
public class CarDTO {
    private Model model;
    private Date start;
    private Date end;
    private Integer citsCount;
    private Integer maxFuelConsumption;
    private TransmissionType transmissionType;
    private CarBodyType bodyType;

//    public Specification<Car> getSpecification(Long modelId) {
//        Specification<Car> specification = CarSpecs.isRentedFalse();
//        if (modelId != null) {
//            specification.and(CarSpecs.modelIdEquals(modelId));
//        }
//
//        if (start != null) {
//            specification.and(CarSpecs.producedDateBigger(start));
//        }
//
//        if (end != null) {
//            specification.and(CarSpecs.producedDateLess(end));
//        }
//
//        if (citsCount != null) {
//            specification.and(CarSpecs.sitsCountEquals(citsCount));
//        }
//
//        if (maxFuelConsumption != null) {
//            specification.and(CarSpecs.fuelConsumptionLess(maxFuelConsumption));
//        }
//
//        if (transmissionType != null) {
//            specification.and(CarSpecs.transmissionEquals(transmissionType));
//        }
//
//        if (bodyType != null) {
//            specification.and(CarSpecs.bodyTypeEquals(bodyType));
//        }
//        return specification;
//    }
}
