package com.pac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pac.model.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {

    long getModelIdByMarkAndGenerationAndModel(String mark, String generation, String model);
}
