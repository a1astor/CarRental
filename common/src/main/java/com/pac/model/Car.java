package com.pac.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    private long id;

    @Column(name = "model_id")
    private long model_id;

    @Column(name = "rented")
    private boolean rented;

    @Column(name = "produced_date")
    private Date produced_date;

    @Column(name = "sits_count")
    private int sits_count;

    @Enumerated(EnumType.STRING)
    @Column(name = "body_type")
    private CarBodyType body_type;

    @Column(name = "fuel_consumption")
    private int fuel_consumption;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission")
    private TransmissionType transmission;

    @Column(name = "autohouse_id")
    private long autohouse_id;

}
