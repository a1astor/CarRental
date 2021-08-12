package com.pac.dao;

import java.util.Optional;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pac.model.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    Optional<Price> findByCar_id(Long carId);
}
