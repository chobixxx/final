package com.groupware.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.dto.BoardDTO;
import com.groupware.dto.ReplyDTO;
import com.groupware.entity.Board;
import com.groupware.entity.Employee;
import com.groupware.exception.MessageException;
import com.groupware.exception.NotExistException;
import com.groupware.repository.BoardRepository;
import com.groupware.repository.ReplyRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	private ModelMapper mapper = new ModelMapper();

	//게시글 작성
	public void save(BoardDTO boardDTO) throws MessageException{
		Board board = Board.toBoard(boardDTO);
		boardRepository.save(board);
	}
	
	//게시글 삭제
	@Transactional
	public void deleteBoard(String Password,int no) {
		
		boardRepository.deleteByPasswordAndNo(Password,no);
	}
	
	//게시판 수정
	@Transactional
	public boolean update(String title, String content, int no,String password) throws NotExistException{
		System.out.println(title+"***"+no+"***"+password);
		int result = boardRepository.updateBoardByNoPassword(no, password, title, content);
		if(result == 0){
			throw new NotExistException("게시판 정보  갱신 실패");
		}
		return true;
	}
	
	
	//자유게시판 글목록
	public List<BoardDTO> getAllBoards(){
		List<Board> boards = boardRepository.findAll(Sort.by(Sort.Direction.DESC,"no"));
		List<BoardDTO> boardDTOs = new ArrayList<>();
		for(Board board : boards) {
			BoardDTO bDto = new BoardDTO() ;
			bDto.setEmpNo(board.getEmpNo());
			bDto.setTitle(board.getTitle());
			bDto.setWritedate(board.getWritedate());
			bDto.setContent(board.getContent());
			bDto.setHit(board.getHit());
			bDto.setNo(board.getNo());
			bDto.setPassword(board.getPassword());
			boardDTOs.add(bDto);
		}
		return boardDTOs;
	}
	
	//자유게시판 상세보기
	public BoardDTO getBoard(int no) throws NotExistException{
		Board board = boardRepository.findById(no).orElseThrow(()-> new NotExistException("게시글이 없습니다."));
		
		return mapper.map(board, BoardDTO.class);
	}



	
	
	
}
