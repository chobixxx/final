package com.groupware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Employee;

public interface TodolistRepository extends JpaRepository<Employee, Integer>{

}
