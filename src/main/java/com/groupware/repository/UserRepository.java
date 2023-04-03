package com.groupware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.approval.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}