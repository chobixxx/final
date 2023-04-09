package com.groupware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Employee;
import com.groupware.entity.Todolist;

public interface TodolistRepository extends JpaRepository<Todolist, Integer>{

	
	List<Todolist> findByEmpNo(Employee e);
	List<Todolist> findAll();
	void deleteByNum(int num);

}
