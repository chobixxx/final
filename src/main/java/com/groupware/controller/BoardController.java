package com.groupware.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.BoardDTO;
import com.groupware.dto.EmployeeDTO;
import com.groupware.dto.ReplyDTO;
import com.groupware.entity.Board;
import com.groupware.entity.Employee;
import com.groupware.entity.Reply;
import com.groupware.exception.MessageException;
import com.groupware.exception.NotExistException;
import com.groupware.service.BoardService;
import com.groupware.service.ReplyService;

@Controller
@RequestMapping("board")
@SessionAttributes({ "emp","empNo", "boardNo"})
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyService replyService;
	
	//자유게시판 전체보기
	@RequestMapping(value = "/boardallview", method = RequestMethod.GET)
	public ModelAndView getBoard() throws SQLException {

		ModelAndView mv = new ModelAndView();

		mv.addObject("allData", boardService.getAllBoards());
		mv.setViewName("../views/board/list");

		return mv;
	}
	
	// 자유게시판 글 상세보기
		@RequestMapping(value = "/boardread", method = RequestMethod.GET)
		public ModelAndView getBoardno(@RequestParam("no") int no, Model model) throws SQLException, NotExistException {
			
			model.addAttribute("boardNo", no);
			System.out.println(no+"***********");
			ModelAndView mv = new ModelAndView();

			mv.addObject("boardData", boardService.getBoard(no));
			mv.setViewName("../views/board/read");
			return mv;
		}
		
		//자유게시판 글 작성
		@RequestMapping(value = "/boardinsert", method = RequestMethod.POST)
		public String boardInsert(@ModelAttribute("BoardDTO") BoardDTO boardDTO, Model model) throws MessageException {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String now = sdf.format(System.currentTimeMillis());
			boardDTO.setWritedate(now);
			boardService.save(boardDTO);
			
			return "redirect:../board/boardallview";
		}
		
		//게시글 수정
		@RequestMapping(value = "/boardupdate", method = RequestMethod.POST)
		public String boardUpdate(@ModelAttribute BoardDTO boardDTO, Model model) throws NotExistException {
			int no = (int) model.getAttribute("boardNo");
			boolean result = boardService.update(boardDTO.getTitle(), boardDTO.getContent(), no,boardDTO.getPassword());
			return "redirect:../board/boardallview";
		}
		
		//게시글 삭제
		@RequestMapping(value = "/boarddelete", method = RequestMethod.GET)
		public String deleteBoard( @RequestParam("password") String password, @RequestParam("no") int no) {
			boardService.deleteBoard(password,no);
			return "redirect:../board/boardallview";
		}
		
		//게시글 수정 폼으로 이동
		@RequestMapping(value = "/boardupdate", method = RequestMethod.GET)
		public String boardUpdate() {
			return "/board/update";
		}
		
		
		
		//게시글 작성 폼으로 이동
		@RequestMapping(value = "/boardinsert", method = RequestMethod.GET)
		public String boardInsert(Model model) {
		  return "/board/write";
		}

		// 게시글 상세보기에서 댓글 list보기
		@ResponseBody
		@RequestMapping(value = "/replyread", produces = "application/json; charset=utf8", method = RequestMethod.POST)
		public List getReplyno(@RequestParam("boardNo") int no) throws SQLException, NotExistException {
			ModelAndView mv1 = new ModelAndView();
			// 해당 게시글의 댓글
			List<ReplyDTO> list = replyService.getReply(no);
			List<HashMap> hmlist = new ArrayList<HashMap>();
			list.forEach(v -> System.out.println(v));
			for (int i = 0; i < list.size(); i++) {
				HashMap hm = new HashMap();
				hm.put("reply", list.get(i).getContent());
				hm.put("writer", list.get(i).getEmpNo().getName());
				hmlist.add(hm);
			}

			hmlist.forEach(v -> System.out.println(v));
			return hmlist;

		}

		// 댓글 입력
		@ResponseBody
		@GetMapping(value = "/addreply", produces = "application/json; charset=UTF-8")
		public String writeReply(Model model, @RequestParam("boardNo") int boardNo, @RequestParam("content") String content)
		throws SQLException {
			Employee employee = (Employee) model.getAttribute("emp");
			int empNo = employee.getEmpNo();
			Board board = new Board(boardNo);
			ReplyDTO replyDTO = new ReplyDTO();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String now = sdf.format(System.currentTimeMillis());
			replyDTO.setWritedate(now);
			replyDTO.setContent(content);
			replyDTO.setBoardNo(board);
			replyDTO.setEmpNo(employee);
			replyService.save(replyDTO);
			return "redirect:../board/boardread"+replyDTO.getBoardNo().getNo();
		}
}
