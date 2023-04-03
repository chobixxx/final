package com.groupware.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.entity.Board;
import com.groupware.entity.Employee;
import com.groupware.entity.Reply;

import team3.groupware5.service.BoardService;
import team3.groupware5.service.ReplyService;

@Controller
@RequestMapping("BoardServlet")
@SessionAttributes({ "board", "reply", "boardNo", "employeeNo" })
public class BoardController {

	@Autowired
	private ReplyService replyService;

	@Autowired
	private BoardService boardService;

	// 자유 게시판 글쓰기
	@RequestMapping(value = "/boardinsert", method = RequestMethod.POST)
	public String insert(Model model, @RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("password") String password) throws SQLException, UnsupportedEncodingException {

		Employee e = new Employee((int) model.getAttribute("employeeNo"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(System.currentTimeMillis());
		Board board = new Board(title, content, password, now, 0, e);
		boardService.writeBoard(board);
		model.addAttribute("board", board);

		return "redirect:boardallview";
	}

	// 자유게시판 글 목록
	@RequestMapping(value = "/boardallview", method = RequestMethod.GET)
	public ModelAndView getBoard() throws SQLException {

		ModelAndView mv = new ModelAndView();

		mv.addObject("allData", boardService.getAllBoards());
		mv.setViewName("../board/list");

		return mv;

	}

	// 게시글 상세보기에서 댓글 list보기
	@ResponseBody
	@RequestMapping(value = "/replyread", produces = "application/json; charset=utf8")
	public ArrayList getReplyno(@RequestParam("boardNo") int no) throws SQLException {
		ModelAndView mv1 = new ModelAndView();
		// 해당 게시글의 댓글
		ArrayList<Reply> list = replyService.getReplyNo(no);
		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
		list.forEach(v -> System.out.println(v));
		for (int i = 0; i < list.size(); i++) {
			HashMap hm = new HashMap();
			hm.put("reply", list.get(i).getContent());
			hm.put("writer", list.get(i).getEmployeeNo().getEmployeeName());
			hmlist.add(hm);
		}

		hmlist.forEach(v -> System.out.println(v));
		return hmlist;

	}

	// 자유게시판 글 상세보기
	@RequestMapping(value = "/boardread", method = RequestMethod.GET)
	public ModelAndView getBoardno(@RequestParam("no") int no, Model model) throws SQLException {
		model.addAttribute("boardNo", no);
		System.out.println(model);
		ModelAndView mv = new ModelAndView();

		mv.addObject("boardData", boardService.getBoardNo(no));
		mv.setViewName("../board/read");
		return mv;
	}

	// 댓글 입력
	@ResponseBody
	@GetMapping(value = "/addreply", produces = "application/json; charset=UTF-8")
	public String writeReply(Model model, @RequestParam("boardNo") int boardNo, @RequestParam("content") String content)
			throws SQLException {

		Employee employee = new Employee((int) model.getAttribute("employeeNo"));
		Board board = new Board(boardNo);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");// db용 날짜 출력 형식으로 초기화
		String now = sdf.format(System.currentTimeMillis());// 오늘 날짜
		Reply reply = new Reply(content, now, employee, board);
		replyService.writeReply(reply);
		model.addAttribute("reply", reply);
		return "success";
	}

	//게시판 수정
	@RequestMapping(value = "/boardupdate", method = RequestMethod.POST)
	public String update(Model model, @RequestParam("content") String content,
			@RequestParam("password") String password, @RequestParam("title") String title) throws SQLException {

		int no = (int) model.getAttribute("boardNo");
		Employee employee = new Employee((int) model.getAttribute("employeeNo"));

		Board board = new Board(no, title, content, password, employee);
		boardService.updateBoard(board);

		return "redirect:boardallview";
	}

	// 비밀번호 받아오기 수정 필요
	@RequestMapping(value = "/boarddelete", method = RequestMethod.GET)
	public String delete(Model sessionData) throws SQLException {

		int boardNo = (int) sessionData.getAttribute("boardNo");
		boardService.deleteBoard(boardNo);
		return "redirect:boardallview";
	}

	@ExceptionHandler
	public String exceptionHandler(SQLException e) {
		e.printStackTrace();
		return e.getMessage();
	}

}