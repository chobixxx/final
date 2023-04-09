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

import com.groupware.service.EmpService;
import com.groupware.service.NoticeService;


@Controller
@RequestMapping("NoticeServlet")
@SessionAttributes({ "notice", "email", "noticeNo", "employeeNo" })
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@Autowired
	private EmpService empService;

//	// 공지사항 글쓰기
//	@RequestMapping(value = "/noticeinsert", method = RequestMethod.POST)
//	public String insert(Model model, @RequestParam("title") String title, @RequestParam("content") String content,
//			@RequestParam("password") String password) throws SQLException {
//
//		Employee e = new Employee((int) model.getAttribute("employeeNo"));
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// 날짜 출력 형식
//		String now = sdf.format(System.currentTimeMillis());// 오늘 날짜로 초기화
//		Notice notice = new Notice(title, content, password, now, 0, e);
//		noticeService.writeNotice(notice);
//		model.addAttribute("notice", notice);
//
//		return "redirect:noticeallview";
//	}

	// 공지 list
	@RequestMapping(value = "/noticeallview", method = RequestMethod.GET)
	public ModelAndView getNotice(Model model) throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.addObject("allData", noticeService.getAllNotice());

		
			mv.setViewName("../views/notice/list");

		return mv;

	}

	// main list
	@RequestMapping(value = "/noticeallviewmain", method = RequestMethod.GET)
	public ModelAndView getNoticeMain(Model model) throws Exception {

		ModelAndView mv = new ModelAndView();

		mv.addObject("allData", noticeService.getAllNotice());
		mv.setViewName("../views/main");
		return mv;

	}

//	 공지 상세보기
	@RequestMapping(value = "/noticeread", method = RequestMethod.GET)
	public ModelAndView getNoticeNo(@RequestParam("no") int no, Model model) throws Exception {
		model.addAttribute("noticeNo", no);
		ModelAndView mv = new ModelAndView();

		
			mv.addObject("data", noticeService.getNotice(no));
			System.out.println(noticeService.getNotice(no)+"*********");
			mv.setViewName("../views/notice/read");
		return mv;
	}

	// 공지 수정
//	@RequestMapping(value = "/noticeupdate", method = RequestMethod.POST)
//	public String update(Model model, @RequestParam("content") String content,
//			@RequestParam("password") String password, @RequestParam("title") String title) throws SQLException {
//
//		int no = (int) model.getAttribute("noticeNo");
//		Employee e = new Employee((int) model.getAttribute("employeeNo"));
//
//		Notice notice = new Notice(no, title, content, password, e);
//		noticeService.updateNotice(notice);
//
//		return "redirect:noticeallview";
//	}

//	// 공지 삭제
//	@RequestMapping(value = "/noticedelete", method = RequestMethod.GET)
//	public String delete(@RequestParam("no") int boardNo) throws SQLException {
//		noticeService.deleteNotice(boardNo);
//		return "redirect:noticeallview";
//	}

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