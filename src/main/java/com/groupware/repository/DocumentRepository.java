package com.groupware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.approval.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
