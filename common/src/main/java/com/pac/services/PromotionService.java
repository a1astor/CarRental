package com.pac.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.pac.model.Promotion;

public interface PromotionService {
    List<Promotion> getAvailablePromotions(Date date);

    Optional<Promotion> findById(long id);
}
