package com.groupware.dto;

import com.groupware.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BoardDTO {
	private int no;
	private String title;
	private String content;
	private String password;
	private String writedate;
	private int hit;
	private Employee empNo;
	
	public BoardDTO(int no) {
		this.no = no;
	}
	
	public BoardDTO (int no, String title,String content,String password, Employee employeeno) {
		this.no=no;
		this.title = title;
		this.content= content;
		this.password= password;
		this.empNo =employeeno;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardDTO [no=").append(no).append(", title=").append(title).append(", content=").append(content)
				.append(", password=").append(password).append(", writedate=").append(writedate).append(", hit=")
				.append(hit).append(", empNo=").append(empNo).append("]");
		return builder.toString();
	}
}