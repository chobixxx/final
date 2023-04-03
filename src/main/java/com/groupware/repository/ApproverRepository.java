package com.groupware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.approval.entity.Approver;

public interface ApproverRepository extends JpaRepository<Approver, Long> {

}
