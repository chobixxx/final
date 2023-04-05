package com.groupware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupware.service.ApproverService;

@RestController
@RequestMapping("/approvers")
public class ApproverController {

    @Autowired
    private ApproverService approverService;

    // 결재
    @PostMapping("/{documentId}/approve")
    public void approveDocument(@PathVariable Long documentId) {
        approverService.approveDocument(documentId, null); //null값을 이메일로 줘야할거같음
    }

    // 보류
    @PostMapping("/{documentId}/hold")
    public void holdDocument(@PathVariable Long documentId) {
        approverService.holdDocument(documentId, null);
    }

    // 반려
    @PostMapping("/{documentId}/reject")
    public void rejectDocument(@PathVariable Long documentId) {
        approverService.rejectDocument(documentId, null);
    }
    
}