package com.groupware.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupware.entity.Document;
import com.groupware.exception.UnauthorizedException;
import com.groupware.service.DocumentService;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    //결재문서 삭제
    @DeleteMapping("/{id}")
    public void deleteDocument (HttpSession session, @PathVariable Long id) {
        if(session.getAttribute("email") != null && session.getAttribute("email").equals("admin@gmail.com")) {
            documentService.deleteDocument(id);
        } else {
            throw new UnauthorizedException("권한이 없습니다.");
        }
    }
    
    //결재문서 생성
    @PostMapping
    public Document createDocument(@RequestBody Document document) {
        return documentService.createDocument(document);
    }
    
 // 문서 수정
    @PutMapping("/{id}")
    public Document updateDocument(@PathVariable Long id, @RequestBody Document updatedDocument) {
        return documentService.updateDocument(id, updatedDocument);
    }
    
 // 문서 조회
    @GetMapping("/{id}")
    public Document getDocument(@PathVariable Long id) {
        return documentService.getDocument(id);
    }
}