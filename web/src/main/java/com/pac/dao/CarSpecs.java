package com.pac.dao;


import com.pac.model.Car;
import com.pac.model.CarBodyType;
import com.pac.model.Car_;
import com.pac.model.TransmissionType;
import com.pac.model.utilsclass.CarDTO;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;


public class CarSpecs {

    private static Specification<Car> isRentedFalse() {
        return (root, query, builder) -> {
            return builder.isFalse(root.get(Car_.rented));
        };
    }

    private static Specification<Car> producedDateLess(Date date) {
        return (root, query, builder) -> {
            return builder.lessThanOrEqualTo(root.get(Car_.produced_date), date);
        };
    }

    private static Specification<Car> producedDateBigger(Date date) {
        return (root, query, builder) -> {
            return builder.greaterThanOrEqualTo(root.get(Car_.produced_date), date);
        };
    }

    private static Specification<Car> modelIdEquals(Long modelId) {
        return (root, query, builder) -> {
            return builder.equal(root.get(Car_.model_id), modelId);
        };
    }

    private static Specification<Car> sitsCountEquals(Integer sitsCount) {
        return (root, query, builder) -> {
            return builder.equal(root.get(Car_.sits_count), sitsCount);
        };
    }

    private static Specification<Car> bodyTypeEquals(CarBodyType carBodyType) {
        return (root, query, builder) -> {
            return builder.equal(root.get(Car_.body_type), carBodyType);

        };
    }

    private static Specification<Car> fuelConsumptionLess(Integer fuelConsumption) {
        return (root, query, builder) -> {
            return builder.lessThanOrEqualTo(root.get(Car_.fuel_consumption), fuelConsumption);
        };
    }

    private static Specification<Car> transmissionEquals(TransmissionType transmissionType) {
        return (root, query, builder) -> {
            return builder.lessThan(root.get(Car_.transmission), transmissionType);
        };
    }

    public static Specification<Car> getSpecification(CarDTO carDTO, Long modelId) {
        Specification<Car> specification = CarSpecs.isRentedFalse();
        if (modelId != null) {
            specification.and(CarSpecs.modelIdEquals(modelId));
        }

        if (carDTO.getStart() != null) {
            specification.and(CarSpecs.producedDateBigger(carDTO.getStart()));
        }

        if (carDTO.getEnd() != null) {
            specification.and(CarSpecs.producedDateLess(carDTO.getEnd()));
        }

        if (carDTO.getCitsCount() != null) {
            specification.and(CarSpecs.sitsCountEquals(carDTO.getCitsCount()));
        }

        if (carDTO.getMaxFuelConsumption() != null) {
            specification.and(CarSpecs.fuelConsumptionLess(carDTO.getMaxFuelConsumption()));
        }

        if (carDTO.getTransmissionType()!= null) {
            specification.and(CarSpecs.transmissionEquals(carDTO.getTransmissionType()));
        }

        if (carDTO.getBodyType()!= null) {
            specification.and(CarSpecs.bodyTypeEquals(carDTO.getBodyType()));
        }
        return specification;
    }
}
