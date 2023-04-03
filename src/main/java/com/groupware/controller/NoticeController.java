package com.groupware.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import team3.groupware5.service.EmployeeService;
import team3.groupware5.service.NoticeService;
import team3.groupware5.vo.Employee;
import team3.groupware5.vo.Notice;

@Controller
@RequestMapping("NoticeServlet")
@SessionAttributes({ "notice", "email", "noticeNo", "employeeNo" })
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@Autowired
	private EmployeeService employeeService;

	// 공지사항 글쓰기
	@RequestMapping(value = "/noticeinsert", method = RequestMethod.POST)
	public String insert(Model model, @RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("password") String password) throws SQLException {

		Employee e = new Employee((int) model.getAttribute("employeeNo"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// 날짜 출력 형식
		String now = sdf.format(System.currentTimeMillis());// 오늘 날짜로 초기화
		NoticeDTO notice = new NoticeDTO(title, content, password, now, 0, e);
		noticeService.writeNotice(notice);
		model.addAttribute("notice", notice);

		return "redirect:noticeallview";
	}

	// 공지 list
	@RequestMapping(value = "/noticeallview", method = RequestMethod.GET)
	public ModelAndView getNotice(Model model) throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.addObject("allData", noticeService.getAllNotices());

		if (employeeService.fineRole((int) model.getAttribute("employeeNo")).equals("admin")) {
			mv.setViewName("../notice/adminlist");
		} else {
			mv.setViewName("../notice/list");
		}

		return mv;

	}

	// main list
	@RequestMapping(value = "/noticeallviewmain", method = RequestMethod.GET)
	public ModelAndView getNoticeMain(Model model) throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.addObject("allData", noticeService.getAllNotices());

		if (employeeService.fineRole((int) model.getAttribute("employeeNo")).equals("admin")) {
			mv.setViewName("../adminmain");
		} else {
			mv.setViewName("../main");
		}

		return mv;

	}

	// 공지 상세보기
	@RequestMapping(value = "/noticeread", method = RequestMethod.GET)
	public ModelAndView getNoticeNo(@RequestParam("no") int no, Model model) throws Exception {
		model.addAttribute("noticeNo", no);
		ModelAndView mv = new ModelAndView();

		if (employeeService.fineRole((int) model.getAttribute("employeeNo")).equals("admin")) {
			mv.addObject("data", noticeService.getNoticeNo(no));
			mv.setViewName("../notice/adminread");
		} else {
			mv.addObject("data", noticeService.getNoticeNo(no));
			mv.setViewName("../notice/read");
		}
		return mv;
	}

	// 공지 수정
	@RequestMapping(value = "/noticeupdate", method = RequestMethod.POST)
	public String update(Model model, @RequestParam("content") String content,
			@RequestParam("password") String password, @RequestParam("title") String title) throws SQLException {

		int no = (int) model.getAttribute("noticeNo");
		Employee e = new Employee((int) model.getAttribute("employeeNo"));

		NoticeDTO notice = new NoticeDTO(no, title, content, password, e);
		noticeService.updateNotice(notice);

		return "redirect:noticeallview";
	}

	// 공지 삭제
	@RequestMapping(value = "/noticedelete", method = RequestMethod.GET)
	public String delete(@RequestParam("no") int boardNo) throws SQLException {
		noticeService.deleteNotice(boardNo);
		return "redirect:noticeallview";
	}

	@ExceptionHandler
	public String exceptionHandler(SQLException e) {
		e.printStackTrace();
		return e.getMessage();
	}

	@ExceptionHandler
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return e.getMessage();
	}

}