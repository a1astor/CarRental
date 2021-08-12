package com.pac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pac.model.Contract;
import com.pac.model.Model;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
