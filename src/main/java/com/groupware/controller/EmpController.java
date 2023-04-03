package com.groupware.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.EmployeeDTO;
import com.groupware.entity.Employee;
import com.groupware.exception.MessageException;
import com.groupware.repository.EmpRepository;
import com.groupware.service.EmpService;

@Controller
@RequestMapping("company")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	
	//회원가입 폼으로 이동 - http://localhost:8024/company/join
	@GetMapping("/join")
	public String joinForm() {
		return "employee/write";
	}
	
	
	//회원가입
	@PostMapping("/join")
	public String joinEmp(@ModelAttribute("EmployeeDTO") EmployeeDTO employeeDTO, Model model) throws MessageException {
		try {
			empService.save(employeeDTO);
			return "employee/joininfo";
		}catch(MessageException e) {
			model.addAttribute("error", e.getMessage());
			return "employee/exitEmail";
		}
		
	}
	
	
//	//이메일 중복 확인
//	@PostMapping("checkEmail")
//    public @ResponseBody String checkEmail(@RequestParam String email) {
//        try {
//            Employee existEmployee = empService.fin
//            if(existEmployee != null) {
//                return "exist";
//            } else {
//                return "not_exist";
//            }
//        } catch (MessageException e) {
//            return "error";
//        }
//    }
	
	
	//로그인
	@PostMapping("/login")
	public ModelAndView login(HttpSession session, @RequestParam String email, @RequestParam String password) {
	    ModelAndView mav = new ModelAndView();
	    
	    // 이메일과 비밀번호를 사용하여 로그인을 시도
	    boolean loginSuccess = empService.login(email, password);
	    
	    if(loginSuccess) {
	        // 로그인 성공 시, 세션에 로그인 정보 저장
	        session.setAttribute("email", email);
	        session.setAttribute("loginStatus", "true");
	        mav.setViewName("main"); // 메인 페이지로 이동
	    } else {
	        // 로그인 실패 시, 로그인 폼 페이지로 다시 이동
	        mav.addObject("error", "이메일 또는 비밀번호가 일치하지 않습니다.");
	        mav.setViewName("index");
	    }
	    
	    return mav;
	}
	
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    // 세션에서 로그인 정보 제거
	    session.removeAttribute("email");
	    session.removeAttribute("loginStatus");
	    return "index";
	}
	
	
	//비밀번호 찾기 폼으로 이동
	@GetMapping("findPw")
	public String findPw() {
		return "employee/findPw";
	}
	
	
	//이메일&이름으로 비밀번호 찾기
	@PostMapping("findPw")
	public ModelAndView findPassword(@RequestParam("email") String email, @RequestParam("name") String name) {
	    String password = empService.findPw(email, name);
	    ModelAndView mv = new ModelAndView("employee/findPwSucecess");
	    mv.addObject("password", password);
	    mv.addObject("email", email);
	    mv.addObject("name", name);
	    return mv;
	}
	
	
	//이메일 찾기 폼으로 이동
	@GetMapping("findEmail")
	public String findEmail() {
		return "employee/findEmail";
	}
	
	
	//사번&비밀번호로 이메일 찾기
	@PostMapping("findEmail")
	public ModelAndView findEmail(@RequestParam("empNo") Integer empNo, @RequestParam("password") String password) {
	    String email = empService.findEmail(empNo, password);
	    ModelAndView mv = new ModelAndView("employee/findEmailSucecess");
	    mv.addObject("email", email);
	    mv.addObject("empNo", empNo);
	    mv.addObject("password", password);
	    return mv;
	}

}
