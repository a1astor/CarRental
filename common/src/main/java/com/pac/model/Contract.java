package com.pac.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_id")
    private long car_id;

    @Column(name = "client_id")
    private long client_id;

    @Column(name = "date_start")
    private Date date_start;

    @Column(name = "date_end")
    private Date date_end;

    @Column(name = "auto_house_id")
    private long auto_house_id;

    @Column(name = "is_active")
    private boolean is_active;

    @Column(name = "promotion_id")
    private Long promotion_id;

    @Column(name = "price_id")
    private long price_id;

    @Column(name = "total_price")
    private long total_price;
}
