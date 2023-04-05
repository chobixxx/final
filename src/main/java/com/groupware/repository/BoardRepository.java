package com.groupware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	List<Board> findAllOrderByNoDesc();
}
