package com.groupware.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Approver;
import com.groupware.entity.Document;

public interface ApproverRepository extends JpaRepository<Approver, Long> {

	Optional<Document> findByEmailAndDocument(String approverEmail, Document document);

}
