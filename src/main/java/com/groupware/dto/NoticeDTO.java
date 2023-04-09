package com.groupware.dto;

import com.groupware.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class NoticeDTO {
	private int no;
	private String title;
	private String content;
	private String password;
	private String writedate;
	private int hit;
	private Employee empNo;
	
	public NoticeDTO (int no,String title,String content,String password,Employee employeeno) {
		this.no=no;
		this.title = title;
		this.content= content;
		this.password= password;
		this.empNo =employeeno;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NoticeDTO [no=");
		builder.append(no);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", password=");
		builder.append(password);
		builder.append(", writedate=");
		builder.append(writedate);
		builder.append(", hit=");
		builder.append(hit);
		builder.append(", empNo=");
		builder.append(empNo);
		builder.append("]");
		return builder.toString();
	}
	

}