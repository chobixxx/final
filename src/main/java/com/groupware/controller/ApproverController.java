package com.groupware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupware.approval.entity.Approver;
import com.groupware.approval.service.ApproverService;

@RestController
@RequestMapping("/approvers")
public class ApproverController {

    @Autowired
    private ApproverService approverService;

    @GetMapping
    public List<Approver> getAllApprovers() {
        return approverService.getAllApprovers();
    }

    @PostMapping
    public Approver createApprover(@RequestBody Approver approver) {
        return approverService.createApprover(approver);
    }

    @GetMapping("/{id}")
    public Approver getApproverById(@PathVariable Long id) {
        return approverService.getApproverById(id);
    }
}