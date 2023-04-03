package com.groupware.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.groupware.entity.Message;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageDto {
	private int id;
	private String title;
	private String content;
	private int senderEmployeeNo;
	private int receiverEmployeeNo;
	//custom
	private String writeDate;
	private boolean isDeleted;
	
	public static MessageDto toDto(Message message) {
		return new MessageDto(
				message.getId(),
				message.getTitle(),
				message.getContent(),
				message.getSender().getEmployeeNo(),
				message.getReceiver().getEmployeeNo(),
				message.getWriteDate(),
				message.isDeleted()
		);
	}
}