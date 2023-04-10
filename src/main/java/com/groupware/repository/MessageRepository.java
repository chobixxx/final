package com.groupware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Employee;
import com.groupware.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	List<Message> findAllByReceiver(Employee employee);
	List<Message> findAllBySender(Employee employee);
}
