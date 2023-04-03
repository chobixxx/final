package com.groupware.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.MessageDto;
import com.groupware.entity.Employee;
import com.groupware.service.MessageService;


@Controller
@RequestMapping("message")
@SessionAttributes({"employeeNo"})
public class MessageController {
	
	@Autowired
	public MessageService messageService;

	
	//받은 편지함
	@GetMapping(value =  "/received/{employeeNo}", produces = "application/json; charset=UTF-8")
	public ModelAndView received(@PathVariable int employeeNo) throws SQLException {	
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("receivedList", messageService.received(new Employee(employeeNo)));
		mv.setViewName("../message/receivedList");
		
		return mv;
	}
	
	
	//보낸 메시지함
	@GetMapping(value =  "/sent/{employeeNo}", produces = "application/json; charset=UTF-8")
	public ModelAndView sent(@PathVariable int employeeNo) throws SQLException {	
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("sentList", messageService.sent(new Employee(employeeNo)));
		mv.setViewName("../message/sentList");
		
		return mv;
	}

	
	//메시지 보내기
	@RequestMapping(value = "/send")
	public void send(MessageDto dto, Model model, HttpServletResponse res) throws Exception {
		
		int empno = (int) model.getAttribute("employeeNo");		
		dto.setSenderEmployeeNo(empno);
		
		messageService.write(dto);

		res.sendRedirect("received/" + empno);
	}
	
	
	//받은 메시지 삭제
	@RequestMapping(value = "/receivedDelete", method = RequestMethod.GET)
	public void receivedDelete(@RequestParam("id") int messageId, HttpServletResponse res, Model model) throws SQLException, IOException {
		
		int empno = (int) model.getAttribute("employeeNo");		
		
		messageService.deleteMessageByReceiver(messageId, new Employee(empno));
		
		res.sendRedirect("received/" + empno);
	}

	
	//보낸 메시지 삭제
	@RequestMapping(value = "/sendDelete", method = RequestMethod.GET)
	public void sendDelete(@RequestParam("id") int messageId, HttpServletResponse res, Model model) throws SQLException, IOException {
		
		int empno = (int) model.getAttribute("employeeNo");	
		
		messageService.deleteMessageBySender(messageId, new Employee(empno));
		
		res.sendRedirect("sent/" + empno);
	}
	
	
	@ExceptionHandler
	public String exceptionHandler(SQLException e) {
		e.printStackTrace();
		return e.getMessage();
   }
}
