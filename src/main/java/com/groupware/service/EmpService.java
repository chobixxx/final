package com.groupware.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.EmployeeDTO;
import com.groupware.entity.Employee;
import com.groupware.exception.MessageException;
import com.groupware.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	private EmpRepository empRepository;
	
	
	//회원가입
	public void save(EmployeeDTO employeeDTO) throws MessageException {
		String mail = employeeDTO.getEmail();
		Employee existEmployee = empRepository.findByEmail(mail);
		if(existEmployee != null) {
			throw new MessageException("이미 등록된 이메일입니다.");
		}else {
			Employee employee = Employee.toEmployee(employeeDTO);
			empRepository.save(employee);
		}
	}
	
	
	//회원가입 - 이메일 중복 체크
	public Employee checkEmail(String email) {
	    return empRepository.findByEmail(email);
	}

	
	//로그인
	public boolean login(HttpSession session, String email, String password) {
	    Employee employee = empRepository.findByEmailAndPassword(email, password);
	    if(employee == null) {
	        return false; // 로그인 실패
	    } else {
	        // 세션에 사용자 정보 저장
	        session.setAttribute("email", email);
	        session.setAttribute("name", employee.getName());
	        session.setAttribute("empNo", employee.getEmpNo());
	        session.setAttribute("loginStatus", "true");
	        session.setAttribute("userRole", employee.getRole());
	        
	        if(employee.getRole().equals("admin")) {
	            return true; // 관리자 계정 로그인 성공
	        } else {
	            return true; // 일반 사용자 로그인 성공
	        }
	    }
	}
	
	
	//이름&이메일로 비밀번호 찾기
    public String findPw(String email, String name) {
        Employee employee = empRepository.findByEmailAndName(email, name);
        if (employee == null) {
            // 해당하는 이메일과 이름을 가진 사용자가 없는 경우
            return null;
        } else {
            // 해당하는 이메일과 이름을 가진 사용자의 비밀번호를 반환
            return employee.getPassword();
        }
    }
    
    
	//사번&비밀번호로 이메일 찾기
    public String findEmail(Integer empNo, String password) {
        Employee employee = empRepository.findByEmpNoAndPassword(empNo, password);
        if (employee == null) {
            // 해당하는 사원번호와 비밀번호를 가진 사용자가 없는 경우
            return null;
        } else {
            // 해당하는 사원번호와 비밀번호를 가진 사용자의 이메일을 반환
            return employee.getEmail();
        }
    }
	
	
	//전체 직원 조회
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = empRepository.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmpNo(employee.getEmpNo());
            employeeDTO.setTeam(employee.getTeam());
            employeeDTO.setEmail(employee.getEmail());
            employeeDTO.setName(employee.getName());
            employeeDTO.setPassword(employee.getPassword());
            employeeDTO.setPosition(employee.getPosition());
            employeeDTO.setGender(employee.getGender());
            employeeDTO.setRole(employee.getRole());
            employeeDTOs.add(employeeDTO);
        }
        return employeeDTOs;
    }
    
    
    //사번으로 직원 찾아서 정보 수정
    public Employee findByEmpNo(Integer empNo) {
        return empRepository.findByEmpNo(empNo);
    }
    
    
    //직원 정보 수정 후 저장
    public void updateEmp(Employee employee) {
        empRepository.save(employee);
    }
    
    
    //직원 정보 삭제
    @Transactional
    public void deleteEmp(Integer empNo) {
        empRepository.deleteByEmpNo(empNo);
    }
    
    
    // 이름으로 직원 검색
    public List<Employee> getEmpByName(String name) {
        List<Employee> employees = empRepository.findByName(name);
        return employees;
    }
	
}
