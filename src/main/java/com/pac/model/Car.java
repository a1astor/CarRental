package com.pac.model;

import lombok.Data;
import com.pac.model.utilsclass.CarBodyType;
import com.pac.model.utilsclass.TransmissionType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model_id")
    private int model_id;

    @Column(name = "buy_date")
    private int buy_date;

    @Column(name = "rented")
    private boolean rented;

    @Column(name = "produced_date")
    private Date produced_date;

    @Column(name = "sits_count")
    private int sits_count;

    @Column(name = "body_type")
    private CarBodyType body_type;

    @Column(name = "fuel_consumption")
    private int fuel_consumption;

    @Column(name = "fuel_consumption")
    private TransmissionType transmission;

    @Column(name = "autohouse_id")
    private int autohouse_id;

}
