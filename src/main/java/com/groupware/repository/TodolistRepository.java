package com.groupware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Todolist;

public interface TodolistRepository extends JpaRepository<Todolist, Integer>{

}
