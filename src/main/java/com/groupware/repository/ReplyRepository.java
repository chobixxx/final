package com.groupware.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.groupware.entity.Board;
import com.groupware.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer>{

	 List<Reply> findByBoardNo( Board boardNo );



	 


	
	
}
