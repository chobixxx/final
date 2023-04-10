package com.groupware.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.groupware.dto.ReplyDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

@NamedQuery(name = "Reply.findReplyNo",
query = "select r from Reply r where r.boardNo.no = :boardNo")

@Entity
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@NonNull
	@Column(length = 50, nullable = false)
	private String content;
	
	@NonNull
	@Column(nullable = false)
	private String writedate;
	
	@ManyToOne
	@NonNull
	@JoinColumn(name="emp_no")
	private Employee empNo;
	
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@NonNull
	@JoinColumn(name="board_no")
	private Board boardNo;


	public static Reply toReply(ReplyDTO replyDTO) {
		Reply reply = new Reply();
		reply.setBoardNo(replyDTO.getBoardNo());
		reply.setContent(replyDTO.getContent());
		reply.setEmpNo(replyDTO.getEmpNo());
		reply.setNo(replyDTO.getNo());
		reply.setWritedate(replyDTO.getWritedate());

		return reply;
	}
	

	
}