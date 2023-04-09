package com.groupware.dto;

import com.groupware.entity.Message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageDto {
	private int id;
	private String title;
	private String content;
	private boolean deletedBySender;
	private boolean deletedByReceiver;
	private int sender;
	private int receiver;
	private String writeDate;
	private boolean isDeleted;
	
	public static MessageDto toDto(Message message) {
		return new MessageDto(
				message.getId(),
				message.getTitle(),
				message.getContent(),
				message.isDeletedBySender(),
				message.isDeletedByReceiver(),
				message.getSender().getEmpNo(),
				message.getReceiver().getEmpNo(),
				message.getWriteDate(),
				message.isDeleted()
		);
	}
}