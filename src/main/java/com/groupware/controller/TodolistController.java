package com.groupware.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.TodolistDTO;
import com.groupware.entity.Employee;
import com.groupware.exception.MessageException;
import com.groupware.service.EmpService;
import com.groupware.service.TodolistService;


@Controller

@RequestMapping("todolist")
@SessionAttributes({ "empNo"})
public class TodolistController {
	
	@Autowired
	public TodolistService tdSve;

	@Autowired
	public EmpService empSve;

	@GetMapping(value =  "/allview", produces = "application/json; charset=UTF-8")
	public ModelAndView allview() throws SQLException {
		System.out.println("m1()");
		System.out.println("------------controller----------");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", tdSve.getAll());
		mv.setViewName("../views/todolist/list");
		
		return mv;
	}
	
	@GetMapping(value =  "/viewtodolist/{empNo}", produces = "application/json; charset=UTF-8")
	public ModelAndView view(@PathVariable int empNo) throws SQLException {			
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", tdSve.getTodolistOne(empNo));
		mv.setViewName("../views/todolist/list");
		return mv;
	}
	
	@ModelAttribute("empNo")
	public Integer getEmpNo(HttpSession session) {
	    return (Integer) session.getAttribute("empNo");
	}
	
//	todolist 작성
	@PostMapping(value = "/inserttodolist")
	public String insert(Model model, @ModelAttribute("TodolistDTO") TodolistDTO tDto, @RequestParam("empNo") String empNo) throws SQLException, IOException, MessageException {
	    Employee employee = empSve.findByEmpNo(Integer.parseInt(empNo));
	    tDto.setEmpNo(employee.getEmpNo());
	    tdSve.save(tDto);
	    int no = employee.getEmpNo();
	    return "redirect:../todolist/viewtodolist/" + no;
	}
	
	//todolist 작성 페이지로 이동
	@RequestMapping(value = "/inserttodolist", method = RequestMethod.GET)
	public String todolistInsert(Model model) {
	    return "todolist/write";
	}


	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("num") int num, Model model,@RequestParam("empNo") int empNo) throws SQLException, IOException {
		tdSve.delete(num);
	    
	    return "redirect:../todolist/viewtodolist/" +empNo;
	}
	
	
	@ExceptionHandler
	public String exProcess(Exception e) {
		e.printStackTrace();
		return null;
		
	}
}
