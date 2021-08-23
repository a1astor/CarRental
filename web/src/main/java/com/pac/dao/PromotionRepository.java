package com.pac.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pac.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    public List<Promotion> findAllByStartDateBeforeAndEndDateAfter(Date curDate, Date date);
}
