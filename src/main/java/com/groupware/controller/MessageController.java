package com.groupware.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.MessageDto;
import com.groupware.entity.Employee;
import com.groupware.entity.Message;
import com.groupware.repository.EmpRepository;
import com.groupware.service.MessageService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("message")
@SessionAttributes({"empNo"})
public class MessageController {
	
	@Autowired
	public MessageService messageService;

	
	//받은 메시지함
	@GetMapping(value =  "/received/{empNo}", produces = "application/json; charset=UTF-8")
	public ModelAndView received(@PathVariable int empNo) throws SQLException {	
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("receivedList", messageService.received(empNo));
		mv.setViewName("../views/message/receivedList");
		
		return mv;
	}
	
	
	//보낸 메시지함
	@GetMapping(value =  "/sent/{empNo}", produces = "application/json; charset=UTF-8")
	public ModelAndView sent(@PathVariable int empNo) throws SQLException {	
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("sentList", messageService.sent(empNo));
		mv.setViewName("../views/message/sentList");
		
		return mv;
	}

	
	//메시지 보내기
    @PostMapping(value = "/send")
	public void send(MessageDto dto, Model model, HttpServletResponse res) throws Exception {
		
		int empNo = (int) model.getAttribute("empNo");
		dto.setSender(empNo);
		messageService.write(dto);

		res.sendRedirect("sent/" + empNo);
	}
    
    //send.jsp 호출
    @RequestMapping(value = "/viewSendPage/{empNo}", method = RequestMethod.GET)
    public ModelAndView viewSendPage(@PathVariable("empNo") int empNo, Model model) {
    	
    	ModelAndView mv = new ModelAndView();

    	model.addAttribute("empNo", empNo);
		
		mv.addObject("empNo", empNo);
		mv.setViewName("../views/message/send");
		
		return mv;
    }

    
    //받은 메시지 삭제
    @GetMapping(value = "/receivedDelete")
    public void receivedDelete(int id, int empNo, HttpServletResponse res) throws Exception {
    	
		messageService.deleteMessageByReceiver(id, empNo);

		res.sendRedirect("received/" + empNo);
    }

	
	//보낸 메시지 삭제
	@GetMapping(value = "/sentDelete")
	public void sentDelete(int id, int empNo, HttpServletResponse res) throws Exception {
		
		messageService.deleteMessageBySender(id, empNo);
		
		res.sendRedirect("sent/" + empNo);
	}
	
	
	@ExceptionHandler
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return e.getMessage();
   }
}
