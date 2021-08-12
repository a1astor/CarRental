package com.pac.services;

import com.pac.model.Contract;
import com.pac.model.Price;

public interface PriceService {
    double calculateContractPrice(Contract contract);
}
