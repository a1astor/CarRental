package com.pac.services;

import java.util.Date;

import com.pac.exceptions.CanNotCreateContractException;
import com.pac.model.Car;
import com.pac.model.Contract;
import com.pac.model.User;

public interface ContractService {
    Contract createNewContract(Car car, Date startDate, Date endDate, Date contractCreatedDate, User user) throws CanNotCreateContractException;
}
