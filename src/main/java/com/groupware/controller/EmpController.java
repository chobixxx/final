package com.groupware.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.groupware.dto.EmployeeDTO;
import com.groupware.entity.Employee;
import com.groupware.exception.LoginFailedException;
import com.groupware.exception.MessageException;
import com.groupware.exception.NotExistException;
import com.groupware.service.EmpService;

@Controller
@RequestMapping("company")
@SessionAttributes({ "emp","empNo", "employeeName"})
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	
	//회원가입 폼으로 이동 - http://localhost:8024/company/join
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm() {
		return "employee/write";
	}
	
	
	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinEmp(@ModelAttribute("EmployeeDTO") EmployeeDTO employeeDTO, Model model) throws MessageException {
		try {
			empService.save(employeeDTO);
			return "employee/joininfo";
		}catch(MessageException e) {
			model.addAttribute("error", e.getMessage());
			return "employee/exitEmail";
		}
		
	}
	
	
	//이메일 중복 확인
	@ResponseBody
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public String checkEmail(@RequestParam("email") String email) {
        try {
            Employee existEmployee = empService.checkEmail(email);
            if(existEmployee != null) {
                return "100";
            } else {
                return "200";
            }
        } catch (Exception e) {
            return "error";
        }
    }
	
	
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, @RequestParam String email, @RequestParam String password) {
	    try {
	        Employee emp = empService.login(email, password);
	        session.setAttribute("emp", emp);
	        
	        if(emp.getEmail().equals("admin@gmail.com")) {
	            session.setAttribute("userRole", "admin");
	        } else {
	            session.setAttribute("userRole", "user");
	        }
	        
	        return "redirect:../NoticeServlet/noticeallviewmain";
	    } catch(LoginFailedException e) {
	        return "redirect:/";
	    }
	}


	//admin 계정으로 로그인
	@RequestMapping(value = "/adminmain", method = RequestMethod.GET)
	public String adminMain(HttpSession session, Model model) {
	    String userRole = (String) session.getAttribute("userRole");
	    if (userRole != null && userRole.equals("admin")) {
	        return "adminmain";
	    } else {
	        return "redirect:/"; // 관리자가 아닐 경우, 로그인 페이지로 이동
	    }
	}
	

	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
	    // 세션에서 로그인 정보 제거
	    session.removeAttribute("email");
	    session.removeAttribute("loginStatus");
	    return "redirect:/";
	}
	
	
	//비밀번호 찾기 폼으로 이동
	@RequestMapping(value = "/findPw", method = RequestMethod.GET)
	public String findPw() {
		return "employee/findPw";
	}
	
	
	//이메일&이름으로 비밀번호 찾기
	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public String findPassword(Model model, @RequestParam("email") String email, @RequestParam("name") String name) {
	    try {
	        String password = empService.findPw(email, name);
	        model.addAttribute("password", password);
	        model.addAttribute("email", email);
	        model.addAttribute("name", name);
	        return "employee/findPwSucecess";
	    } catch (NotExistException e) {
	        return "employee/findFail";
	    }
	}
	
	
	//이메일 찾기 폼으로 이동
	@RequestMapping(value = "/findEmail", method = RequestMethod.GET)
	public String findEmail() {
		return "employee/findEmail";
	}
	
	
	//사번&비밀번호로 이메일 찾기
	@RequestMapping(value = "/findEmail", method = RequestMethod.POST)
	public String findEmail(Model model, @RequestParam("empNo") Integer empNo, @RequestParam("password") String password) {
	    try {
	        String email = empService.findEmail(empNo, password);
	        model.addAttribute("email", email);
	        model.addAttribute("empNo", empNo);
	        model.addAttribute("password", password);
	        return "employee/findEmailSucecess";
	    } catch (NotExistException e) {
	        return "employee/findFail";
	    }
	}
	
}
