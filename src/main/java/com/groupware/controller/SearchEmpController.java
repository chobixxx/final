package com.groupware.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	//전체 직원 목록 - http://localhost:8024/company/allEmp
	@RequestMapping(value = "/allEmp", method = RequestMethod.GET)
	public ModelAndView getEmployees(HttpSession session) {
	    ModelAndView mv = new ModelAndView();
	    String userRole = (String) session.getAttribute("userRole");
	    
	    List<EmployeeDTO> employees = empService.getAllEmployees();
	    mv.addObject("employees", employees);
	    
	    if(userRole != null && userRole.equals("admin")) {
	        mv.setViewName("list/listAdmin");
	    } else {
	        mv.setViewName("list/listEmp");
	    }
	    
	    return mv;
	}
	    
	
	//이름으로 직원 정보 검색
	@RequestMapping(value = "/searchEmp", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@RequestParam String search, HttpSession session) {
	    ModelAndView mv = new ModelAndView();
	    String userRole = (String) session.getAttribute("userRole");
	    
	    if(userRole != null && userRole.equals("admin")) {
	        List<Employee> employees = empService.getEmpByName(search);
	        mv.addObject("employees", employees);
	        mv.setViewName("list/listAdmin");
	    } else {
	        List<Employee> employees = empService.getEmpByName(search);
	        mv.addObject("employees", employees);
	        mv.setViewName("list/listEmp");
	    }
	    
	    return mv;
	}
	
	
	//직원 정보 수정(admin) - 폼으로 이동
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateEmp(@RequestParam("empNo") Integer empNo, Model model) {
		Employee employee = empService.findByEmpNo(empNo);
		model.addAttribute("employee", employee); // 수정된 employee 객체를 model에 추가
		return "list/update";
	}
	
	
	//직원 정보 수정(admin)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute("employee") Employee employee) {
	    empService.updateEmp(employee);
	    return "search/updateSuccess";
	}
	
	
	//직원 정보 삭제(admin)
	@Transactional
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEmp(@RequestParam("empNo") Integer empNo, Model model) {
	    empService.deleteEmp(empNo);
	    List<EmployeeDTO> employees = empService.getAllEmployees();
	    model.addAttribute("employees", employees);
	    return "list/listAdmin";
	}

}
