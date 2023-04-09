package com.groupware.dto;
import com.groupware.entity.Board;
import com.groupware.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReplyDTO {

	private int no;
	private String content;
	private String writedate;
	private Employee empNo;
	private Board boardNo;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReplyDTO [no=");
		builder.append(no);
		builder.append(", content=");
		builder.append(content);
		builder.append(", writedate=");
		builder.append(writedate);
		builder.append(", empNo=");
		builder.append(empNo.getEmpNo());
		builder.append(", boardNo=");
		builder.append(boardNo.getNo());
		builder.append("]");
		return builder.toString();
	}
	
	
}