package com.groupware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.approval.entity.Approver;
import com.groupware.approval.exception.NotFoundException;
import com.groupware.approval.repository.ApproverRepository;

@Service
public class ApproverService {

    @Autowired
    private ApproverRepository approverRepository;

    public List<Approver> getAllApprovers() {
        return approverRepository.findAll();
    }

    public Approver createApprover(Approver approver) {
        return approverRepository.save(approver);
    }

    public Approver getApproverById(Long id) {
        return approverRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Approver not found"));
    }

}