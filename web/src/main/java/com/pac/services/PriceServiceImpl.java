package com.pac.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pac.dao.PriceRepository;

import com.pac.model.Contract;
import com.pac.model.Price;
import com.pac.model.Promotion;

@Service
public class PriceServiceImpl implements PriceService {
    public static final double ONE_HUNDRED = 100;
    private PriceRepository priceRepository;
    private PromotionServiceImpl promotionService;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository, PromotionServiceImpl promotionService) {
        this.priceRepository = priceRepository;
        this.promotionService = promotionService;
    }

    @Override
    public double calculateContractPrice(Contract contract) {
        Long promotion_id = contract.getPromotion_id();
        Optional<Promotion> promotion = Optional.empty();
        if (promotion_id != null) {
            promotion = promotionService.findById(promotion_id);
        }
        Price price = getPriceByCarID(contract.getPrice_id());
        double promotionPercent = promotion.map(Promotion::getPromotion).orElse(0.0);
        return addPercentToPrice(price.getStart_price(), price.getAmortization_coeff(), price.getProfitability_coeff(), promotionPercent);
    }

    public Price getPriceByCarID(Long carId) {
        return priceRepository.findByCarIdEquals(carId).orElseThrow();
    }

    private double addPercentToPrice(double price, double... percents) {
        double curPrice = price;
        for (double percent : percents) {
            price += addPercentToPrice(price, percent);
        }
        return curPrice;
    }

    private double addPercentToPrice(double price, double percent) {
        return price + (price * percent) / ONE_HUNDRED;
    }
}
