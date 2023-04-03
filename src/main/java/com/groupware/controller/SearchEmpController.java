package com.groupware.controller;

import java.util.List;

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
	public ModelAndView getEmployees() {
	    ModelAndView mv = new ModelAndView("employeeList");
	    List<EmployeeDTO> employees = empService.getAllEmployees();
	    mv.addObject("employees", employees);
	    mv.setViewName("list/listEmp");
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

}
