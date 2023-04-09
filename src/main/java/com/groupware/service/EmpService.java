package com.groupware.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.groupware.dto.EmployeeDTO;
import com.groupware.entity.Document;
import com.groupware.entity.Employee;
import com.groupware.exception.LoginFailedException;
import com.groupware.exception.MessageException;
import com.groupware.exception.NotExistException;
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
	public Employee login(String email, String password) throws LoginFailedException {
	    Employee employee = empRepository.findByEmailAndPassword(email, password);
	    if (employee == null) {
	        throw new LoginFailedException("Invalid email or password");
	    }
	    return employee;
	}
	
	
	//이름&이메일로 비밀번호 찾기
	public String findPw(String email, String name) throws NotExistException {
	    Employee employee = empRepository.findByEmailAndName(email, name);
	    if (employee == null) {
	        throw new NotExistException("해당하는 이메일과 이름을 가진 사용자가 없습니다.");
	    } else {
	        return employee.getPassword();
	    }
	}
    
    
	//사번&비밀번호로 이메일 찾기
	public String findEmail(Integer empNo, String password) throws NotExistException {
	    Employee employee = empRepository.findByEmpNoAndPassword(empNo, password);
	    if (employee == null) {
	        throw new NotExistException("해당하는 사원번호와 비밀번호를 가진 사용자가 없습니다.");
	    } else {
	        return employee.getEmail();
	    }
	}
	
	
	//전체 직원 조회
	public List<EmployeeDTO> getAllEmployees() throws NotExistException {
	    List<Employee> employees = empRepository.findAll();
	    if (employees.isEmpty()) {
	        throw new NotExistException("No employees found");
	    }
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
	public Employee findByEmpNo(Integer empNo) throws NotExistException {
	    Employee employee = empRepository.findByEmpNo(empNo);
	    if (employee == null) {
	        throw new NotExistException("사번 " + empNo + "에 해당하는 직원이 없습니다.");
	    }
	    return employee;
	}
    
    
    //직원 정보 수정 후 저장
	public void updateEmp(Employee employee) throws DataAccessResourceFailureException {
	    if (employee.getEmail() == null) {
	        throw new IllegalArgumentException("이메일 항목은 비워둘 수 없습니다.");
	    }
	    try {
	        empRepository.save(employee);
	    } catch (Exception e) {
	        throw new DataAccessResourceFailureException("직원 정보 수정에 실패했습니다.", e);
	    }
	}
    
    
    //직원 정보 삭제
    @Transactional
    public void deleteEmp(Integer empNo) throws DataAccessResourceFailureException {
        try {
            empRepository.deleteByEmpNo(empNo);
        } catch (Exception e) {
            throw new DataAccessResourceFailureException("Failed to delete employee", e);
        }
    }
    
    
    // 이름으로 직원 검색
    public List<Employee> getEmpByName(String name) {
        List<Employee> employees = empRepository.findByName(name);
        if (employees.isEmpty()) {
            return Collections.emptyList();
        }
        return employees;
    }

	
}
