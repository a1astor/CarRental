package com.pac.dao;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;

import com.pac.model.Car;
import com.pac.model.CarBodyType;
import com.pac.model.TransmissionType;

public class CarSpecs {

    public static Specification<Car> isRentedFalse() {
        return (root, query, builder) -> {
            return builder.isFalse(root.get("rented"));
        };
    }

    public static Specification<Car> producedDateLess(Date date) {
        return (root, query, builder) -> {
            return builder.lessThanOrEqualTo(root.get("produced_date"), date);
        };
    }

    public static Specification<Car> producedDateBigger(Date date) {
        return (root, query, builder) -> {
            return builder.greaterThanOrEqualTo(root.get("produced_date"), date);
        };
    }

    public static Specification<Car> modelIdEquals(Long modelId) {
        return (root, query, builder) -> {
            return builder.equal(root.get("model_id"), modelId);
        };
    }

    public static Specification<Car> sitsCountEquals(Integer sitsCount) {
        return (root, query, builder) -> {
            return builder.equal(root.get("sits_count"), sitsCount);
        };
    }

    public static Specification<Car> bodyTypeEquals(CarBodyType carBodyType) {
        return (root, query, builder) -> {
            return builder.equal(root.get("body_type"), carBodyType);
        };
    }

    public static Specification<Car> fuelConsumptionLess(Integer fuelConsumption) {
        return (root, query, builder) -> {
            return builder.lessThanOrEqualTo(root.get("fuel_consumption"), fuelConsumption);
        };
    }

    public static Specification<Car> transmissionEquals(TransmissionType transmissionType) {
        return (root, query, builder) -> {
            return builder.lessThan(root.get("transmission"), transmissionType);
        };
    }
}
