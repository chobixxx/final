package team3.groupware5.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import team3.groupware5.repository.EmployeeDAO;
import team3.groupware5.repository.TodolistDAO;
import team3.groupware5.service.TodolistService;
import team3.groupware5.vo.Employee;
import team3.groupware5.vo.Todolist;

@RestController
@RequestMapping("todolist")
@SessionAttributes({ "employeeNo"})
public class TodolistController {
	
	@Autowired
	public TodolistService tdSve;
	@Autowired
	public TodolistDAO tdDao;
	@Autowired
	public EmployeeDAO dao;

	@GetMapping(value =  "/allview", produces = "application/json; charset=UTF-8")
	public ModelAndView allview() throws SQLException {
		System.out.println("m1()");
		System.out.println("------------controller----------");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", tdSve.getTodolist());
		mv.setViewName("../todolist/list");
		
		return mv;
	}
	
	@GetMapping(value =  "/viewtodolist/{employeeNo}", produces = "application/json; charset=UTF-8")
	public ModelAndView view(@PathVariable int employeeNo) throws SQLException {			
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", tdSve.getTodolistOne(employeeNo));
		mv.setViewName("../todolist/list");
		return mv;
	}
	
	@PostMapping(value = "/insert")
	public void insert(Model model,
			@RequestParam("title") String title,
			@RequestParam("importance") String importance,
			@RequestParam("content") String content,
			@RequestParam("date") String date,
			@RequestParam("time") String time,
			HttpServletResponse res) throws SQLException, IOException  {
		System.out.println(title);
		int empno =(int) model.getAttribute("employeeNo");		
		int imp= Integer.parseInt(importance);
		Employee e = new Employee(empno);
		Todolist todolist = new Todolist(title, content, imp, date, time, e);
		tdSve.insert(todolist);
		model.addAttribute("todolist", todolist);
		
		System.out.println("insert() -----");
		res.sendRedirect("allview");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam("num") int num, HttpServletResponse res,Model model) throws SQLException, IOException  {
		tdSve.delete(num);
		System.out.println("delete() ----********-");
		res.sendRedirect("viewtodolist/"+(int) model.getAttribute("employeeNo"));
	}
	
	@ExceptionHandler
	public String exProcess(Exception e) {
		e.printStackTrace();
		return null;
		
	}
}
