package com.groupware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

	List<Document> findByStatus(String status);
	List<Document> findByTitleContainingIgnoreCase(String keyword);
	Document findByDocNum(Long docNum);
	void deleteByDocNum(Long docNum);

}
