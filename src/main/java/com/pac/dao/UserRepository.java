package com.pac.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pac.model.secutiry.User;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
