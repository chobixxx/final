//package com.groupware.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.groupware.entity.Document;
//import com.groupware.repository.DocumentRepository;
//
//import com.groupware.exception.NotFoundException;
//
//
//@Service
//public class DocumentService {
//
//    @Autowired
//    private DocumentRepository documentRepository;
//    
//
//    //결재문서 목록
//    public List<Document> getAllDocuments() {
//        return documentRepository.findAll();
//    }
//
//    //결재문서 생성
//    public Document createDocument(Document document) {
//        return documentRepository.save(document);
//    }
//    
//    //결재문서 수정
//    public Document updateDocument(Document document) {
//        Document existingDocument = documentRepository.findById(document.getId())
//            .orElseThrow(() -> new NotFoundException("문서가 없습니다."));
//
//        existingDocument.setTitle(document.getTitle());
//        existingDocument.setContent(document.getContent());
//
//        return documentRepository.save(existingDocument);
//    }
//    
//    //결재문서 수정2 뭐가 나은지 모르겠음
//    public Document updateDocument(Long id, Document updatedDocument) {
//        Document document = documentRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("문서가 없습니다."));
//        document.setTitle(updatedDocument.getTitle());
//        document.setContent(updatedDocument.getContent());
//        document.setApprover(updatedDocument.getApprover());
//        document.setEmployee(updatedDocument.getEmployee());
//        return documentRepository.save(document);
//    }
//
//    //결재문서 검색? 조회? 있어야 하나?
//    public Document getDocument(Long id) {
//        return documentRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("문서가 없습니다."));
//    }
//    
//    //결재문서 삭제
//    public void deleteDocument(Long id) {
//        Document document = documentRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("문서가 없습니다."));
//        documentRepository.delete(document);
//    }
//    
//}