package com.pac.model;

import lombok.Data;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Cacheable
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int car_id;

    @Column(name = "start_price")
    private int start_price;

    @Column(name = "profitability_coeff")
    private int profitability_coeff;

    @Column(name = "amortization_coeff")
    private int amortization_coeff;
}