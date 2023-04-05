package com.groupware.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	//초기 화면 - http://localhost:8024/
	@GetMapping("/")
	public String home() {
		return "/index";
	}
	
	
	//메인으로 이동
	@GetMapping("/main")
	public String main(Model model, HttpSession session) {
	    String userRole = (String) session.getAttribute("userRole");
	    if(userRole.equals("admin")) {
	        return "adminmain";
	    } else {
	        return "main";
	    }
	}

}
