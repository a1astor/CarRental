package com.pac.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pac.dao.PromotionRepository;
import com.pac.model.Promotion;
import com.pac.services.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {
    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public List<Promotion> getAvailablePromotions(Date date) {
        return promotionRepository.findAllByStart_dateLessThanEqualAndEnd_dateBefore(date);
    }

    @Override
    public Optional<Promotion> findById(long id) {
        return promotionRepository.findById(id);
    }
}
