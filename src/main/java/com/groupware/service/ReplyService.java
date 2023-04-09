package com.groupware.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.ReplyDTO;
import com.groupware.entity.Board;
import com.groupware.entity.Reply;
import com.groupware.exception.NotExistException;
import com.groupware.repository.BoardRepository;
import com.groupware.repository.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public List<ReplyDTO> getReply(int no) throws NotExistException {
		Board b = boardRepository.findById(no).orElseThrow(()-> new NotExistException("게시글이 없습니다."));
		List<Reply> replies = replyRepository.findByBoardNo(b);
		List<ReplyDTO> replyDTOs = new ArrayList<ReplyDTO>();
		for(Reply reply : replies) {
			ReplyDTO rDto = new ReplyDTO();
			rDto.setBoardNo(reply.getBoardNo());
			rDto.setContent(reply.getContent());
			rDto.setEmpNo(reply.getEmpNo());
			rDto.setNo(reply.getNo());
			rDto.setWritedate(reply.getWritedate());
			replyDTOs.add(rDto);
		}
		return replyDTOs;
	}
	
	public void saveReply() {
		
		
	}

	public void save(ReplyDTO replyDTO) {
		Reply reply = Reply.toReply(replyDTO);
		replyRepository.save(reply);
		
	}


}
