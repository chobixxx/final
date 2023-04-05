package com.groupware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.entity.Document;
import com.groupware.entity.Employee;
import com.groupware.repository.DocumentRepository;


@Service
public class ApproverService {

    
    @Autowired
    private DocumentRepository documentRepository;
    
    @Autowired
    private EmpService empService;

    public void approveDocument(Long documentId, String approverEmail) {
        Document document = documentRepository.findById(documentId) // empno로 바꿔야하나?
            .orElseThrow(() -> new IllegalArgumentException("문서id가 잘못 되었습니다."));

        Employee approver = empService.findByEmail(approverEmail)
            .orElseThrow(() -> new IllegalArgumentException("잘못된 이메일입니다."));

        if (!document.getApprover().getEmail().equals(approver.getEmail())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }

        document.setStatus(DocumentStatus.APPROVED);
        documentRepository.save(document);
    }

    public void holdDocument(Long documentId, String approverEmail) {
        Document document = documentRepository.findById(documentId)
            .orElseThrow(() -> new IllegalArgumentException("문서id가 잘못 되었습니다."));

        Employee approver = empService.findByEmail(approverEmail)
            .orElseThrow(() -> new IllegalArgumentException("잘못된 이메일입니다."));

        if (!document.getApprover().getEmail().equals(approver.getEmail())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }

        document.setStatus(DocumentStatus.HOLD);
        documentRepository.save(document);
    }

    public void rejectDocument(Long documentId, String approverEmail) {
        Document document = documentRepository.findById(documentId)
            .orElseThrow(() -> new IllegalArgumentException("문서id가 잘못 되었습니다."));

        Employee approver = empService.findByEmail(approverEmail)
            .orElseThrow(() -> new IllegalArgumentException("잘못된 이메일입니다."));

        if (!document.getApprover().getEmail().equals(approver.getEmail())) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }

        document.setStatus(DocumentStatus.REJECTED);
        documentRepository.save(document);
    }
}