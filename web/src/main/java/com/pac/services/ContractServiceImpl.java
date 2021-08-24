package com.pac.services;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.pac.dao.ContractRepository;
import com.pac.dao.UserRepository;

import com.pac.exceptions.CanNotCreateContractException;
import com.pac.model.Car;
import com.pac.model.Contract;
import com.pac.model.Promotion;
import com.pac.model.User;

@Service
public class ContractServiceImpl implements ContractService {

    private ContractRepository contractRepository;

    private PromotionService promotionService;

    private PriceService priceService;

    private UserRepository userRepository;

    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository, PromotionServiceImpl promotionService, PriceServiceImpl priceService, UserRepository userRepository) {
        this.contractRepository = contractRepository;
        this.promotionService = promotionService;
        this.priceService = priceService;
        this.userRepository = userRepository;
    }

    @Override
    public Contract createNewContract(Car car, Date startDate, Date endDate, Date contractCreatedDate) throws CanNotCreateContractException {
        validateDates(startDate, endDate, contractCreatedDate);
        Contract contract = new Contract();
        contract.setCar_id(car.getId());
        contract.set_active(true);
        contract.setAuto_house_id(car.getAutohouse_id());
        contract.setDate_start(startDate);
        contract.setDate_end(endDate);
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByEmail(email).orElseThrow(CanNotCreateContractException::new);
        contract.setClient_id(currentUser.getId());
        setPromotionToContract(contract, contractCreatedDate);
        contract.setTotal_price(calculateTotalPrice(contract, startDate, endDate));
        contractRepository.save(contract);
        return contract;
    }

    private void validateDates(Date startDate, Date endDate, Date contractCreatedDate) throws CanNotCreateContractException {
        boolean endLessThenStart = endDate.compareTo(startDate) < 0;
        boolean curDateMoreThenEndDate = contractCreatedDate.compareTo(endDate) > 0;
        if (endLessThenStart || curDateMoreThenEndDate) {
            throw new CanNotCreateContractException();
        }
    }

    private long calculateTotalPrice(Contract contract, Date startDate, Date endDate) {
        double price = priceService.calculateContractPrice(contract);
        long daysCount = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
        return (long) (price * daysCount);
    }

    private void setPromotionToContract(Contract contract, Date contractCreatedDate) {
        List<Promotion> availablePromotions = promotionService.getAvailablePromotions(contractCreatedDate);
        if (!availablePromotions.isEmpty()) {
            Promotion promotion = availablePromotions.stream().max(Comparator.comparingDouble(Promotion::getPromotion)).get();
            contract.setPromotion_id(promotion.getId());
        }
    }
}
