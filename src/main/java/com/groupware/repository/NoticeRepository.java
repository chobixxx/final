package com.groupware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupware.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer>{

	List<Notice> findAll();
}
