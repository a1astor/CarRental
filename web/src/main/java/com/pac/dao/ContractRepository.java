package com.pac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pac.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
