package com.groupware.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	//초기 화면 - http://localhost:8024/
	@GetMapping("/")
	public String home() {
		return "/index";
	}
	
	
	//메인 화면
	@GetMapping("/main")
	public String main() {
		return "/main";
	}
	
	
	//관리자 메인 화면
	@GetMapping("/admain")
	public String adminMain() {
		return "/adminmain";
	}

}
