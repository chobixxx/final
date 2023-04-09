package com.groupware.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.groupware.dto.EmployeeDTO;
import com.groupware.dto.NoticeDTO;
import com.groupware.entity.Employee;
import com.groupware.entity.Notice;
import com.groupware.exception.NotExistException;
import com.groupware.repository.EmpRepository;
import com.groupware.repository.NoticeRepository;

@Service
public class NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private EmpRepository empRepository;
	
	private ModelMapper mapper = new ModelMapper();

	//공지사항 작성
	public void insert(Model model, @RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("password") String password)  {
		
		Employee e = new Employee((int) model.getAttribute("employeeNo"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// 날짜 출력 형식
		String now = sdf.format(System.currentTimeMillis());// 오늘 날짜로 초기화
		Notice notice = new Notice(title, content, password, now, 0, e);
		noticeRepository.save(notice);
		model.addAttribute("notice", notice);

	}
	
	//공지 상세 보기
	public NoticeDTO getNotice(int no) throws NotExistException{
		Notice notice= noticeRepository.findById(no).orElseThrow(()-> new NotExistException("공지사항이 없습니다."));
		System.out.println(notice.toString()+"-------------");
		
		return mapper.map(notice, NoticeDTO.class);
		
	}
	
	
	public List<NoticeDTO> getAllNotice(){
		 List<Notice> notices = noticeRepository.findAll(Sort.by(Sort.Direction.DESC,"no"));
	     List<NoticeDTO> NoticeDTOs = new ArrayList<>();
	     for(Notice notice : notices) {
	    	 NoticeDTO NoticeDto = new NoticeDTO();
	    	 NoticeDto.setNo(notice.getNo());
	    	 NoticeDto.setTitle(notice.getTitle());
	    	 NoticeDto.setContent(notice.getContent());
	    	 NoticeDto.setEmpNo(notice.getEmpNo());
	    	 NoticeDto.setHit(notice.getHit());
	    	 NoticeDto.setWritedate(notice.getWritedate());
	    	 NoticeDto.setPassword(notice.getPassword());
	    	 NoticeDTOs.add(NoticeDto);
	     }
	     System.out.println(NoticeDTOs+"----------------");
	     return NoticeDTOs;
	}
	
}
