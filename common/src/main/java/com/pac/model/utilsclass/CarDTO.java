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
}
