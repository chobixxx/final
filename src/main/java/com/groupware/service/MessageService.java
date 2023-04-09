package com.groupware.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupware.dto.MessageDto;
import com.groupware.entity.Employee;
import com.groupware.entity.Message;
import com.groupware.repository.EmpRepository;
import com.groupware.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MessageService {
	
    private final MessageRepository messageRepository;
    private final EmpRepository empRepository;

	
	@Transactional
	public MessageDto write(MessageDto messageDto) throws Exception {
		Employee receiver = empRepository.findByEmpNo(messageDto.getReceiver());
		Employee sender = empRepository.findByEmpNo(messageDto.getSender());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//날짜 출력 형식
		String now = sdf.format(System.currentTimeMillis());//오늘 날짜로 초기화
		
		Message message = new Message();
		message.setReceiver(receiver);
		message.setSender(sender);
		message.setTitle(messageDto.getTitle());
		message.setContent(messageDto.getContent());
		message.setDeletedByReceiver(false);
		message.setDeletedBySender(false);
		message.setWriteDate(now);
		
		messageRepository.save(message);
		
		return MessageDto.toDto(message);
	}

	
	//받은 편지함 불러오기
	@Transactional(readOnly = true)
	public List<MessageDto> received(int empNo) {
		Employee receiver = empRepository.findByEmpNo(empNo);

		//받은 편지함 불러오기
		//한 명의 유저가 받은 모든 메시지
		List<Message> messages = messageRepository.findAllByReceiver(receiver);
		List<MessageDto> messageDtos = new ArrayList<>();
		
		for(Message message : messages) {
			//message에서 받은 편지함에서 미삭제시 보낼 때 추가하여 발송
			if(!message.isDeletedByReceiver()) {
				messageDtos.add(MessageDto.toDto(message));
			}
		}
		return messageDtos;
	}
	
	
	//받은 편지 삭제
	@Transactional
	public Object deleteMessageByReceiver(int id, int empNo) {
		Employee receiver = empRepository.findByEmpNo(empNo);

		Message message = messageRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("메시지를 찾을 수 없습니다.");
		});
		
		if(receiver == message.getReceiver()) {
			message.deletedByReceiver(); //받은 사람에게 메시지 삭제
			if(message.isDeleted()) {
				//받은 사람과 보낸 사람 모두 삭제 시 DB에서 삭제
				messageRepository.delete(message);
				return "양쪽 모두 삭제";
			}
			return "한쪽만 삭제";
		}else {
			return new IllegalArgumentException("유저 정보가 일치하지 않습니다.");
		}
	}
		
	
	//보낸 편지함 불러오기
    @Transactional(readOnly = true)
    public List<MessageDto> sent(int empNo) {
		Employee sender = empRepository.findByEmpNo(empNo);

        List<Message> messages = messageRepository.findAllBySender(sender);
        List<MessageDto> messageDtos = new ArrayList<>();

        for(Message message : messages) {
            // message 에서 받은 편지함에서 삭제하지 않았으면 보낼 때 추가하여 발송
            if(!message.isDeletedBySender()) {
                messageDtos.add(MessageDto.toDto(message));
            }
        }
        return messageDtos;
    }

    
    //보낸 편지 삭제
	@Transactional
	public Object deleteMessageBySender(int id, int empNo) {
		Employee sender = empRepository.findByEmpNo(empNo);
		
		Message message = messageRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("메시지를 찾을 수 없습니다.");
		});
		
		if(sender == message.getSender()) {
			message.deletedBySender(); //받은 사람에게 메시지 삭제
			if(message.isDeleted()) {
				//받은 사람과 보낸 사람 모두 삭제 시 DB에서 삭제
				messageRepository.delete(message);
				return "양쪽 모두 삭제";
			}
			return "한쪽만 삭제";
		}else {
			return new IllegalArgumentException("유저 정보가 일치하지 않습니다.");
		}
	}
}
