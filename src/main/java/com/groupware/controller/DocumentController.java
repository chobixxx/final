package com.groupware.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.entity.Document;
import com.groupware.exception.UnauthorizedException;
import com.groupware.service.DocumentService;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;
    
  //전체 문서 목록
    @GetMapping("/listDoc")
    public ModelAndView getAllDocuments(HttpSession session) {
        ModelAndView mv = new ModelAndView();
        String userRole = (String) session.getAttribute("userRole");

        List<Document> documents = documentService.getAllDocuments();
        mv.addObject("documents", documents);

        if (userRole != null && userRole.equals("admin")) {
            mv.setViewName("list/listDocAdmin");
        } else {
            mv.setViewName("list/listDoc");
        }

        return mv;
    }
    
    //새 글 작성
    @GetMapping("/new")
    public String showNewDocumentForm(Model model) {
        model.addAttribute("document", new Document());
        return "document-form";
    }
    
  //문서 검색
    @GetMapping("/search")
    public ModelAndView searchDocuments(String keyword) {
        ModelAndView mv = new ModelAndView();
        List<Document> documents = documentService.searchDocuments(keyword);
        mv.addObject("documents", documents);
        mv.setViewName("list/listDoc");
        return mv;
    }
    
 // 문서 삭제
    @PostMapping("/document/delete")
    public void deleteDocuments(@RequestParam("checked") Integer[] deleteIds, HttpSession session) throws UnauthorizedException {
        String userRole = (String) session.getAttribute("userRole");
        
        if (userRole != null && userRole.equals("admin")) {
            for (Integer empNo : deleteIds) {
                documentService.deleteDocument(empNo);
            }
        } else {
            throw new UnauthorizedException("권한이 없습니다.");
        }
    }
    
    //작성자만 문서 수정 기능을 추가 하고싶은데 일단 보류
    
}