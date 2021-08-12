package com.pac.services;

import java.util.Date;

import com.pac.model.Contract;

public interface RentService {
    Contract rent(long carId, Date startDate, Date endDate);
}
