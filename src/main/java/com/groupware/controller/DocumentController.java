package com.groupware.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.DocumentDTO;
import com.groupware.dto.EmployeeDTO;
import com.groupware.entity.Document;
import com.groupware.exception.MessageException;
import com.groupware.exception.NotExistException;
import com.groupware.exception.UnauthorizedException;
import com.groupware.service.DocumentService;
import com.groupware.service.EmpService;

@Controller
@RequestMapping("document")
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@Autowired
	private EmpService empService;
	
	// 전체 문서 목록(일반계정)
	@GetMapping("/listDoc")
	public ModelAndView getAllDocuments(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String userRole = (String) session.getAttribute("userRole");

		List<Document> documents = documentService.getAllDocuments();

		mv.addObject("documents", documents);

		if (userRole != null && userRole.equals("admin")) {
			mv.setViewName("document/listDocAdmin");
		} else {
			mv.setViewName("document/listDoc");
		}

		return mv;
	}

	// 전체 문서 목록(admin계정)
	@GetMapping("/listDocAdmin")
	public ModelAndView getAllDocumentsForAdmin(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String userRole = (String) session.getAttribute("userRole");

		List<Document> documents = documentService.getAllDocuments();

		mv.addObject("documents", documents);

		if (userRole != null && userRole.equals("admin")) {
			mv.setViewName("document/listDocAdmin");
		} else {
			throw new UnauthorizedException("접근 권한이 없습니다.");
		}

		return mv;
	}

	// 문서 작성
	@RequestMapping(value = "/documentinsert", method = RequestMethod.POST)
	public String dInsert(@ModelAttribute("DocumentDTO") DocumentDTO documentDTO, Model model) throws MessageException {

		documentService.save(documentDTO);
		return "redirect:../document/listDoc";
	}

//	// 문서 수정(작성자만)
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String updateDoc(@ModelAttribute("documentDTO") DocumentDTO documentDTO, HttpSession session)
//			throws NotExistException, UnauthorizedException {
//		Long docNum = documentDTO.getDocNum();
//		String loginUser = (String) session.getAttribute("userId");
//		if (!documentService.getDocumentByDocNum(docNum).getAuthor().equals(loginUser)) {
//			throw new UnauthorizedException("수정 권한이 없습니다.");
//		}
//		documentService.updateDocument(documentDTO);
//		return "redirect:/document/listDoc";
//	}
	
	// 문서 수정
	@RequestMapping(value = "/document/updateDoc", method = RequestMethod.POST)
	public String updateDoc(@ModelAttribute("documentDTO") DocumentDTO documentDTO) 
	        throws NotExistException {
	    
	    Long docNum = documentDTO.getDocNum();
	    documentService.updateDocument(documentDTO);
	    return "redirect:/document/listDoc";
	}

	// 문서 삭제(userRole.equals("admin")인 사람만)
	@Transactional
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteDocument(@RequestParam Long docNum, HttpSession session) {
		Document document = documentService.getDocumentByDocNum(docNum);
		String userRole = (String) session.getAttribute("userRole");

		if (userRole.equals("admin")) {
			documentService.deleteDocument(document.getDocNum());
		}

		return "redirect:/document/listDocAdmin";
	}

	// 문서 작성으로 이동
	@RequestMapping(value = "/documentinsert", method = RequestMethod.GET)
	public String documentInsert(Model model) {
		return "/document/write";
	}

//	// 문서 수정으로 이동
//	@RequestMapping(value = "/documentupdate", method = RequestMethod.GET)
//	public String documentUpdate(@RequestParam("docNum") Long docNum, Model model) throws NotExistException {
//		Document document = documentService.getDocumentByDocNum(docNum);
//		DocumentDTO documentDTO = new DocumentDTO(document);
//		model.addAttribute("documentDTO", documentDTO);
//		return "/document/update";
//	}
	
	// 문서 수정 페이지로 이동
	@GetMapping("/documentupdate/{docNum}")
	public String documentUpdate(@PathVariable Long docNum, Model model) throws NotExistException {
	    Document document = documentService.getDocumentByDocNum(docNum);

	    DocumentDTO documentDTO = new DocumentDTO(document);
	    model.addAttribute("documentDTO", documentDTO);
	    return "/document/update";
	}

	// 문서 결재 처리
	@RequestMapping(value = "/documentupdate", method = RequestMethod.POST)
	public String approveDocument(@RequestParam("docNum") Long docNum, @RequestParam String status,
			HttpSession session, Model model) throws NotExistException {
		try {
			String userRole = (String) session.getAttribute("userRole");
			if (userRole == null || !userRole.equals("admin")) {
				throw new UnauthorizedException("접근 권한이 없습니다.");
			}
			documentService.approveDocument(docNum, status);
			model.addAttribute("message", "문서 결재 처리가 완료되었습니다.");
		} catch (UnauthorizedException e) {
			model.addAttribute("errorMessage", e.getMessage());
		} catch (Exception e) {
			model.addAttribute("errorMessage", "문서 결재 처리 중 오류가 발생했습니다.");
		}
		return "redirect:/document/listDocAdmin";
	}
	
	
	@RequestMapping(value = "/changestatus", method = RequestMethod.POST)
	@ResponseBody
	public DocumentDTO changeStatus(@RequestParam("docNum") Long docNum,
	                                 @RequestParam("newStatus") String newStatus) {
	    return documentService.changeStatus(docNum, newStatus);
	}
	
	@GetMapping("/list")
	public String listDocuments(Model model) {
	    List<DocumentDTO> documents = documentService.getDocuments();
	    model.addAttribute("documents", documents);
	    return "document/list";
	}

}
