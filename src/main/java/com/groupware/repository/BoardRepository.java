package com.groupware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Employee;

public interface BoardRepository extends JpaRepository<Employee, Integer>{

}
