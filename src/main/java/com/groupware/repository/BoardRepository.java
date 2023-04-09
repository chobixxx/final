package com.groupware.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.groupware.entity.Board;
@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{

	List<Board> findAll();
	
	@Modifying
	@Query("DELETE FROM Board b WHERE b.no = :no AND b.password = :password")
	void deleteByPasswordAndNo(@Param("password") String password, @Param("no") int no);
	
	@Modifying
	@Query("update Board b set b.title=:title, b.content=:content, b.password=:password where b.no=:no")
	int updateBoardByNoPassword(@Param("no")int no, @Param("password") String password,@Param("title") String title, @Param("content") String content );


}
