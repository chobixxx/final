package com.groupware.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.EmployeeDTO;
import com.groupware.entity.Employee;
import com.groupware.service.EmpService;

@Controller
@RequestMapping("company")
public class SearchEmpController {
	
	@Autowired
	private EmpService empService;
	
	
	//전체 직원 목록
	@GetMapping("/allEmp")
	public ModelAndView getEmployees(HttpSession session) {
	    ModelAndView mv = new ModelAndView();
	    if(session.getAttribute("email") != null && session.getAttribute("email").equals("admin@gmail.com")) {
	        List<EmployeeDTO> employees = empService.getAllEmployees();
	        mv.addObject("employees", employees);
	        mv.setViewName("list/listAdmin");
	    } else {
	    	List<EmployeeDTO> employees = empService.getAllEmployees();
	    	mv.addObject("employees", employees);
	        mv.setViewName("list/listEmp"); // 권한이 없는 사용자의 경우 접근 거부 페이지로 이동
	    }
	    return mv;
	}
	    
	
	
	//이름으로 직원 정보 검색
	@GetMapping("/searchName")
	public ModelAndView searchByName(@RequestParam("name") String name) {
	    List<Employee> employees = empService.getEmpByName(name);
	    ModelAndView mv = new ModelAndView("employeeList");
	    mv.addObject("employees", employees);
	    return mv;
	}
	
	
	//직원 정보 수정(admin) - 폼으로 이동
	@GetMapping("/update")
	public String updateEmp() {
		return "list/update";
	}
	
	
	//직원 정보 삭제(admin)

}
