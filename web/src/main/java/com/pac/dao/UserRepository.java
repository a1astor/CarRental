package com.pac.dao;

import java.util.Optional;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pac.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    Optional<User> findByEmail(String email);
}
