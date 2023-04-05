package com.groupware.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupware.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer>{

	Reply findByBoardNo(int boardNo);
	
	
}
